package com.github.kpossoli.projetopcp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.github.kpossoli.projetopcp.model.Aluno;
import com.github.kpossoli.projetopcp.repository.AlunoRepository;
import com.github.kpossoli.projetopcp.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public Aluno obter(Long id) {
        return alunoRepository.findById(id)
            .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno criar(Aluno aluno) {
        log.info("Criando aluno", aluno);

        var usuario = usuarioRepository.findById(aluno.getUsuario().getId())
            .orElseThrow(() -> new EmptyResultDataAccessException(1));

        aluno.setUsuario(usuario);

        return alunoRepository.save(aluno);
    }
    
    @Override
    public Aluno atualizar(Long id, Aluno aluno) {
        log.info("Atualizando aluno de id: {}", id);

        Aluno alunoSalvo = obter(id);
		BeanUtils.copyProperties(aluno, alunoSalvo, "id");
        return alunoRepository.save(alunoSalvo);
    }
    
    @Override
    public void excluir(Long id) {
        log.info("Excluindo aluno de id: {}", id);

        alunoRepository.deleteById(id);
    }
        
}
