package com.rf.relatorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rf.relatorio.entity.RegistroHoras;

public interface RegistroHorasRepository extends JpaRepository<RegistroHoras, Long> {
	
	List<RegistroHoras> findByUsuarioId(Long usuarioId);
	
}
