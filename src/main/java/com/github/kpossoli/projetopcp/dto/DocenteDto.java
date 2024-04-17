package com.github.kpossoli.projetopcp.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DocenteDto {

	private Long id;

	private Long version;

	private String nome;

	private LocalDate dataEntrada;

	private UsuarioDto usuario;

}
