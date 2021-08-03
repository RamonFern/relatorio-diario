package com.rf.relatorio.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class RelatorioDTO {

	private Long id;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private String data;
	
	@NotEmpty
	private boolean alteracao;

	@NotEmpty
	private String equipe;
	
	@NotEmpty
	private String texto;
	
	@NotEmpty
	private String texto2;
	
	@NotEmpty
	private String texto3;

	@NotEmpty
	private String inspetor;

}
