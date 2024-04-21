package com.github.kpossoli.projetopcp.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DocenteDto {

	private Long id;

	@NotBlank
	private String nome;

	@NotNull
	private LocalDate dataEntrada;

	@NotNull
	@JsonIgnore
	private UsuarioDto usuario;

}
