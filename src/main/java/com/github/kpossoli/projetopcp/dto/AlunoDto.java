package com.github.kpossoli.projetopcp.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AlunoDto {

	private Long id;

	private String nome;

	private LocalDate dataNascimento;

	private UsuarioDto usuario;

}
