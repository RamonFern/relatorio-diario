package com.rf.relatorio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rf.relatorio.entity.Equipe;
import com.rf.relatorio.repository.EquipeRepository;

@Service
public class EquipeService {
	
	private EquipeRepository equipeRepository;
	
	@Autowired
	public EquipeService(EquipeRepository equipeRepository) {
		this.equipeRepository = equipeRepository;
	}
	
	public Equipe createEquipe(Equipe equipe) {
		return equipeRepository.save(equipe);
	}
	

	
}
