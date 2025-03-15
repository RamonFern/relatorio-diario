package com.rf.relatorio.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rf.relatorio.entity.RegistroHoras;

public interface RegistroHorasRepository extends JpaRepository<RegistroHoras, Long> {
	 
	  List<RegistroHoras> findByAgenteIdAndDataHoraInicioBetween(
	            Long agente_id, LocalDateTime inicio, LocalDateTime fim); 
	 
	 
	  List<RegistroHoras> findByAgente_IdAndDataHoraInicioBetween(
		        Long agenteId, LocalDateTime inicio, LocalDateTime fim
		    );
	
}
