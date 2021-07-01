package com.rf.relatorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Relatorio> findAll() {
		return relatorioRepository.findAll();
	}
	
	

}
