package com.rf.relatorio.service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rf.relatorio.entity.AgenteUser;
import com.rf.relatorio.entity.RegistroHoras;
import com.rf.relatorio.repository.AgenteUserRepository;
import com.rf.relatorio.repository.RegistroHorasRepository;

@Service
public class HorasTrabalhadasService {

	@Autowired
    private AgenteUserRepository usuarioRepository;

    @Autowired
    private RegistroHorasRepository  registroHorasRepository;
    
    public RegistroHoras salvarRegistroHoras(RegistroHoras registroHoras) {
        return registroHorasRepository.save(registroHoras);
    }
    
    public long calcularHorasTrabalhadasPorUsuario(Long usuarioId) {
        List<RegistroHoras> registros = registroHorasRepository.findByUsuarioId(usuarioId);
        long totalHoras = 0;

        for (RegistroHoras registro : registros) {
            LocalTime entrada = LocalTime.parse(registro.getHoraEntrada());
            LocalTime saida = LocalTime.parse(registro.getHoraSaida());
            Duration duracao = Duration.between(entrada, saida);
            totalHoras += duracao.toHours();
        }

        return totalHoras;
    }

    public long calcularHorasTrabalhadasPorEquipe(Long equipeId) {
        List<AgenteUser> membros = usuarioRepository.findByEquipeId(equipeId);
        long totalHoras = 0;

        for (AgenteUser membro : membros) {
            totalHoras += calcularHorasTrabalhadasPorUsuario(membro.getId());
        }

        return totalHoras;
    }
}
