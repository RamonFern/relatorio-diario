package com.rf.relatorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rf.relatorio.dto.response.MessageResponseDTO;
import com.rf.relatorio.entity.Relatorio;
import com.rf.relatorio.service.RelatorioService;

@RestController
@RequestMapping("/api/v1/relatorio")
public class RelatorioController {

	private RelatorioService relatorioService;

	@Autowired
	public RelatorioController(RelatorioService relatorioService) {
		this.relatorioService = relatorioService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createRelatorio(@RequestBody Relatorio relatorio) {
		return relatorioService.createRelatorio(relatorio);				
	}
	
	
}
