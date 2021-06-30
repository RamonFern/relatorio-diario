package com.rf.relatorio.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.rf.relatorio.dto.RelatorioDTO;
import com.rf.relatorio.entity.Relatorio;

@Component
public class RelatorioMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public Relatorio toRelatorio(RelatorioDTO dto) {
		return MODEL_MAPPER.map(dto, Relatorio.class);
	}
	
	public RelatorioDTO toDTO(Relatorio relatorio) {
		return MODEL_MAPPER.map(relatorio, RelatorioDTO.class);
	}
}

 