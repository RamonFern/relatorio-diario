package com.rf.relatorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rf.relatorio.service.HorasTrabalhadasService;

@RestController
@RequestMapping("/horas")
public class HorasTrabalhadasController {
	
	 @Autowired
	 private HorasTrabalhadasService horasTrabalhadasService;
	 
	 
	 @GetMapping("/usuario/{usuarioId}")
     public long getHorasTrabalhadasPorUsuario(@PathVariable Long usuarioId) {
        return horasTrabalhadasService.calcularHorasTrabalhadasPorUsuario(usuarioId);
     }
	 
	  @GetMapping("/equipe/{equipeId}")
     public long getHorasTrabalhadasPorEquipe(@PathVariable Long equipeId) {
        return horasTrabalhadasService.calcularHorasTrabalhadasPorEquipe(equipeId);
     }

}
