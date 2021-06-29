package com.rf.relatorio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rf.relatorio.entity.Relatorio;

@RestController
@RequestMapping("/api/v1/relatorio")
public class RelatorioController {

	@GetMapping
	public String getRelatorio() {
		Relatorio relatorio = new Relatorio();
		relatorio.setInspetor("Rodrigo");
		relatorio.setTexto("relatorio diário de serviço");
		return "Teste API relatório dmt "+ relatorio.getTexto();
		
	}
}
