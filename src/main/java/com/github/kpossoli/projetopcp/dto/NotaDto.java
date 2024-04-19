package com.github.kpossoli.projetopcp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class NotaDto {

	private Long id;

	private BigDecimal valor;

	private LocalDate data;

	private AlunoDto aluno;

	private DocenteDto docente;

	private MateriaDto materia;

}
