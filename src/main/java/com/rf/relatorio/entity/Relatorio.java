package com.rf.relatorio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Relatorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String data;
	
	@Column(nullable = false)
	private boolean alteracao;
	
	@Column(nullable = false)
	private String equipe;
	
	@Column(nullable = false)
	private String texto;
	
	@Column(nullable = false)
	private String texto2;
	
	@Column(nullable = false)
	private String texto3;
	
	@Column(nullable = false)
	private String inspetor;
}
