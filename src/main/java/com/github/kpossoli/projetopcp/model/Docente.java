package com.github.kpossoli.projetopcp.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(of = "id")
public class Docente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Version
	@Getter
	private Long version;

	@Getter @Setter
	private String nome;

	@Column(name = "data_entrada")
	@Getter @Setter
	private LocalDate dataEntrada;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	@Getter @Setter
	private Usuario usuario;

}
