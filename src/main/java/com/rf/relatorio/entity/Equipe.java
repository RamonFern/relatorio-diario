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
public class Equipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nomeEquipe;
	
//	@Column
//	private String id_agentes;
	
//	@OneToMany
//    @JoinColumn(name = "equipe_id")
//    private List<AgenteUser> agentes;
	
	
	
	
	

}
