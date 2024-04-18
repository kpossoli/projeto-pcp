package com.github.kpossoli.projetopcp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(of = "id")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Long id;

	@Getter @Setter
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_docente")
	@Getter @Setter
	private Docente docente;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "id_turma")
	private List<Aluno> alunos = new ArrayList<>();

	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	public void removeAluno(Aluno aluno) {
		alunos.remove(aluno);
	}

	public List<Aluno> getAlunos() {
		return Collections.unmodifiableList(alunos);
	}

}
