package com.github.kpossoli.projetopcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.kpossoli.projetopcp.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}