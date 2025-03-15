package com.rf.relatorio.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rf.relatorio.dto.HorasTrabalhadasDTO;
import com.rf.relatorio.dto.RegistroHorasDTO;
import com.rf.relatorio.entity.AgenteUser;
import com.rf.relatorio.entity.RegistroHoras;
import com.rf.relatorio.mapper.HoraTrabalhadasMapper;
import com.rf.relatorio.service.AgenteUserService;
import com.rf.relatorio.service.HorasTrabalhadasService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v2/horas")
@CrossOrigin(origins = "*")
public class HorasTrabalhadasController {
	
	 @Autowired
	 private HorasTrabalhadasService registroHorasService;
	 
	 @Autowired
	 private AgenteUserService agenteUserService;
	 	 
	 @Autowired
	 private HoraTrabalhadasMapper horasTrabalhadasMapper;
	 
	 @PostMapping("/salvar")
     public RegistroHoras salvarRegistro(@RequestBody RegistroHorasDTO dto) {
		AgenteUser agente = agenteUserService.findById(dto.getAgente_id());
		
		RegistroHoras registroHoras = this.horasTrabalhadasMapper.toRegistroHoras(dto);
		
		registroHoras.setAgente(agente);
        return registroHorasService.salvarRegistroHoras(registroHoras);
     }
	 
	 @Operation(summary = "Buscar todos os registros")
	 @GetMapping
	 public ResponseEntity<List<RegistroHorasDTO>> buscarTodosRegistros(){
		 List<RegistroHoras> regList = registroHorasService.buscarTodosRegistroHorasRepository();
		 List<RegistroHorasDTO> regListDTO = horasTrabalhadasMapper.toRegistroHorasDTOList(regList);
		 return ResponseEntity.ok(regListDTO);
	 
	 } 
	 

	 @GetMapping("/calcular-horas")
     public HorasTrabalhadasDTO calcularHorasTrabalhadas(
            @RequestParam Long agenteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {

        return registroHorasService.calcularHorasTrabalhadas(agenteId, dataInicio, dataFim);
     }
	
	

}
