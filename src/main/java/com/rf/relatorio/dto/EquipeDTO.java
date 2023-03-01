package com.rf.relatorio.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquipeDTO {
	
	private Long id;
	
	@NotEmpty
	private String nomeEquipe;
	
	@NotEmpty
	private String id_agentes;
//	private List<AgenteUser> agentes;

}
