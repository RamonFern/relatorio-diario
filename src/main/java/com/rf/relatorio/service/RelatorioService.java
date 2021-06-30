package com.rf.relatorio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rf.relatorio.dto.response.MessageResponseDTO;
import com.rf.relatorio.entity.Relatorio;
import com.rf.relatorio.repository.RelatorioRepository;

@Service
public class RelatorioService {
	
	private RelatorioRepository relatorioRepository;

	@Autowired
	public RelatorioService(RelatorioRepository relatorioRepository) {
		this.relatorioRepository = relatorioRepository;
	}
	
	public MessageResponseDTO createRelatorio(Relatorio relatorio) {
		Relatorio relatorioCriado = relatorioRepository.save(relatorio);
		return MessageResponseDTO
				.builder()
				.message("Relatório criado com sucesso id = " + relatorioCriado.getId())
				.build();
		
	}
	
	

}
