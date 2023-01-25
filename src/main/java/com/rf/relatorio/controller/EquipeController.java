package com.rf.relatorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rf.relatorio.dto.EquipeDTO;
import com.rf.relatorio.entity.Equipe;
import com.rf.relatorio.mapper.EquipeMapper;
import com.rf.relatorio.service.EquipeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v2/equipe")
@CrossOrigin(origins = "http://localhost:4200/")
//@CrossOrigin(origins = "https://front-relatorio-v2.herokuapp.com/")
public class EquipeController {
	
	private EquipeService equipeService;
	private EquipeMapper equipeMapper;
	
	@Autowired
	public EquipeController(EquipeService equipeService, EquipeMapper equipeMapper) {
		this.equipeService = equipeService;
		this.equipeMapper = equipeMapper;
	}
	
	@Operation(summary = "Criar equipe")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<EquipeDTO> createEquipe(@RequestBody EquipeDTO equipeDTO) {
		Equipe novaEquipe = equipeMapper.toEquipe(equipeDTO);
		Equipe equipeCriada = equipeService.createEquipe(novaEquipe);
		
		EquipeDTO dto = equipeMapper.toEquipeDTO(equipeCriada);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
		
	}

}
