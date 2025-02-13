package com.rf.relatorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rf.relatorio.dto.RegistroHorasDTO;
import com.rf.relatorio.entity.AgenteUser;
import com.rf.relatorio.entity.RegistroHoras;
import com.rf.relatorio.repository.AgenteUserRepository;
import com.rf.relatorio.service.HorasTrabalhadasService;

@RestController
@RequestMapping("/api/v2/horas")
public class HorasTrabalhadasController {
	
	 @Autowired
	 private HorasTrabalhadasService horasTrabalhadasService;
	 
	 @Autowired
	 private AgenteUserRepository agenteUserRepository;
	 

	 @PostMapping
	 public RegistroHoras salvarRegistroHoras(@RequestBody RegistroHorasDTO registroHorasDTO) {
	     // Converte o DTO para a entidade
	     RegistroHoras registroHoras = new RegistroHoras();
	     registroHoras.setData(registroHorasDTO.getData());
	     registroHoras.setHoraEntrada(registroHorasDTO.getHoraEntrada());
	     registroHoras.setHoraSaida(registroHorasDTO.getHoraSaida());

	     
		// Busca o AgenteUser pelo ID (você precisará de um repositório para AgenteUser)
	     AgenteUser usuario = this.agenteUserRepository.findById(registroHorasDTO.getUsuarioId())
	             .orElseThrow(() -> new RuntimeException("AgenteUser não encontrado"));
	     registroHoras.setUsuario(usuario);

	     return this.horasTrabalhadasService.salvarRegistroHoras(registroHoras);
	 }
	 
	 @GetMapping("/usuario/{usuarioId}")
     public long getHorasTrabalhadasPorUsuario(@PathVariable Long usuarioId) {
        return horasTrabalhadasService.calcularHorasTrabalhadasPorUsuario(usuarioId);
     }
	 
	 @GetMapping("/equipe/{equipeId}")
     public long getHorasTrabalhadasPorEquipe(@PathVariable Long equipeId) {
        return horasTrabalhadasService.calcularHorasTrabalhadasPorEquipe(equipeId);
     }

}
