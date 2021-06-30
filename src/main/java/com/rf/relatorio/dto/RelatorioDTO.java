package com.rf.relatorio.dto;

import java.time.LocalDate;

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
	private LocalDate data;

	@NotEmpty
	private String texto;

	@NotEmpty
	private String inspetor;

}
