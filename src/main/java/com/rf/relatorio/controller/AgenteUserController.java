package com.rf.relatorio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rf.relatorio.entity.AgenteUser;

@RestController
@RequestMapping("/api/v2/agenteUser")
public class AgenteUserController {
	
	@GetMapping
	public String getAgenteUser() {
		AgenteUser agente = new AgenteUser();
		agente.setCodigo(9038);
		agente.setFuncao("chefe");
		agente.setNome("paulo");
		System.out.println(agente);
		return "Teste api agente user!! " + agente.getNome();
	}

}
