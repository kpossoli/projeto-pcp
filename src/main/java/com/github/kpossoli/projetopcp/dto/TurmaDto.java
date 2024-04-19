package com.github.kpossoli.projetopcp.dto;

import java.util.List;

import lombok.Data;

@Data
public class TurmaDto {

	private Long id;

	private String nome;

	private DocenteDto docente;

	private List<AlunoDto> alunos;

}
