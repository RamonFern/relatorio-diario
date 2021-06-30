package com.rf.relatorio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rf.relatorio.entity.Relatorio;
import com.rf.relatorio.repository.RelatorioRepository;

@Service
public class RelatorioService {
	
	private RelatorioRepository relatorioRepository;

	@Autowired
	public RelatorioService(RelatorioRepository relatorioRepository) {
		this.relatorioRepository = relatorioRepository;
	}
	
	public Relatorio createRelatorio(Relatorio relatorio) {
		return  relatorioRepository.save(relatorio); 
	}
	
	

}
