package com.github.kpossoli.projetopcp.dto;

import java.util.List;

import lombok.Data;

@Data
public class CursoDto {

	private Long id;

	private Long version;

	private String nome;

	private List<MateriaDto> materias;

	private List<TurmaDto> trumas;

}
