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
    
//    public RegistroHoras salvarRegistroHoras(RegistroHoras registroHoras) {
//        return registroHorasRepository.save(registroHoras);
//    }
    
    /**
     * Salva um novo registro de horas ou falta.
     *
     * @param registroHoras O registro a ser salvo.
     * @return O registro salvo.
     * @throws IllegalArgumentException Se as regras de negócio não forem atendidas.
     */
    public RegistroHoras salvarRegistroHoras(RegistroHoras registroHoras) {
        // Validações
        if (registroHoras.isFalta()) {
            // Se o agente faltou, os campos de horaEntrada e horaSaida devem ser nulos
            if (registroHoras.getHoraEntrada() != null || registroHoras.getHoraSaida() != null) {
                throw new IllegalArgumentException("Para registros de falta, os campos 'horaEntrada' e 'horaSaida' devem ser nulos.");
            }
        } else {
            // Se o agente não faltou, os campos de horaEntrada e horaSaida são obrigatórios
            if (registroHoras.getHoraEntrada() == null || registroHoras.getHoraSaida() == null) {
                throw new IllegalArgumentException("Para registros normais, os campos 'horaEntrada' e 'horaSaida' são obrigatórios.");
            }
        }

        // Verifica se o usuário existe
        AgenteUser usuario = usuarioRepository.findById(registroHoras.getUsuario().getId())
                .orElseThrow(() -> new IllegalArgumentException("AgenteUser não encontrado."));

        // Associa o usuário ao registro
        registroHoras.setUsuario(usuario);

        // Salva o registro no banco de dados
        return registroHorasRepository.save(registroHoras);
    }
    
    /**
     * Busca todos os registros de horas de um AgenteUser.
     *
     * @param usuarioId O ID do AgenteUser.
     * @return Uma lista de registros de horas.
     */
    public List<RegistroHoras> buscarRegistrosPorUsuario(Long usuarioId) {
        return registroHorasRepository.findByUsuarioId(usuarioId);
    }
    
    
    /**
     * Busca todos os registros de horas.
     *
     * @return Uma lista de todos os registros de horas.
     */
    public List<RegistroHoras> buscarTodosRegistros() {
        return registroHorasRepository.findAll();
    }
    
    /**
     * Busca registros de falta de um AgenteUser.
     *
     * @param usuarioId O ID do AgenteUser.
     * @return Uma lista de registros de falta.
     */
    public List<RegistroHoras> buscarFaltasPorUsuario(Long usuarioId) {
        return registroHorasRepository.findByUsuarioIdAndFaltaTrue(usuarioId);
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
