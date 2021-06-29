package com.rf.relatorio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/relatorio")
public class RelatorioController {

	@GetMapping
	public String getRelatorio() {
		return "Teste API relatorio...";
	}
}
