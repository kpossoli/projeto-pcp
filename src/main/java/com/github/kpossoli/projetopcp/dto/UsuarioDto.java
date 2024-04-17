package com.github.kpossoli.projetopcp.dto;

import lombok.Data;

@Data
public class UsuarioDto {

	private Long id;

	private Long version;

	private String nome;

	private String login;

	private String senha;

	private PapelDto papel;

}
