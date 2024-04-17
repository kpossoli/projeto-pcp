package com.github.kpossoli.projetopcp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(of = "id")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Version
	@Getter
	private Long version;

	@Getter @Setter
	private String nome;

	@Getter @Setter
	private String login;

	@Getter @Setter
	private String senha;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_papel")
	@Getter @Setter
	private Papel papel;

}
