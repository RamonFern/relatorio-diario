package com.rf.relatorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rf.relatorio.dto.RelatorioDTO;
import com.rf.relatorio.entity.Relatorio;
import com.rf.relatorio.mapper.RelatorioMapper;
import com.rf.relatorio.service.RelatorioService;

@RestController
@RequestMapping("/api/v1/relatorio")
@CrossOrigin(origins = "https://front-relatorio-v2.herokuapp.com/")
//@CrossOrigin(origins = "http://localhost:4200/")
public class RelatorioController {

	
	private final RelatorioService relatorioService;
	
	private final RelatorioMapper relatorioMapper;

	@Autowired
	public RelatorioController(RelatorioService relatorioService, RelatorioMapper relatorioMapper) {
		this.relatorioService = relatorioService;
		this.relatorioMapper = relatorioMapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<RelatorioDTO> createRelatorio(@RequestBody RelatorioDTO relatorioDto) {
		Relatorio relatorio = relatorioMapper.toRelatorio(relatorioDto);
		Relatorio createRelatorio = relatorioService.createRelatorio(relatorio);
		RelatorioDTO dto = relatorioMapper.toDTO(createRelatorio);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);					
	}
	
	@GetMapping
	public ResponseEntity<List<RelatorioDTO>> findAll(){
		List<Relatorio> list = relatorioService.findAll();
		List<RelatorioDTO> relatorioDTOList = relatorioMapper.toRelatorioDTOList(list);
		return ResponseEntity.ok(relatorioDTOList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RelatorioDTO> findById(@PathVariable Long id) {
		Relatorio relatorio = relatorioService.findById(id);
		RelatorioDTO relatorioDTO = relatorioMapper.toDTO(relatorio);
		return ResponseEntity.ok(relatorioDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		relatorioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RelatorioDTO> update(@PathVariable Long id, @RequestBody RelatorioDTO relatorioDTO) {
		Relatorio relatorioAtualizada = relatorioMapper.toRelatorio(relatorioDTO);
		Relatorio pessoa = relatorioService.update(id, relatorioAtualizada);
		return ResponseEntity.ok(relatorioMapper.toDTO(pessoa));
	}
	
	
}
