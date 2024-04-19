package com.github.kpossoli.projetopcp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.github.kpossoli.projetopcp.model.Turma;
import com.github.kpossoli.projetopcp.repository.DocenteRepository;
import com.github.kpossoli.projetopcp.repository.TurmaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TurmaServiceImpl implements TurmaService {

    private final TurmaRepository turmaRepository;
    private final DocenteRepository docenteRepository;

    @Override
    public Turma obter(Long id) {
        return turmaRepository.findById(id)
            .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public List<Turma> listar() {
        return turmaRepository.findAll();
    }

    @Override
    public Turma criar(Turma turma) {
        var docente = docenteRepository.findById(turma.getDocente().getId())
            .orElseThrow(() -> new EmptyResultDataAccessException(1));
            
            
        turma.setDocente(docente);

        return turmaRepository.save(turma);
    }
    
    @Override
    public Turma atualizar(Long id, Turma turma) {
        Turma turmaSalva = obter(id);
		BeanUtils.copyProperties(turma, turmaSalva, "id");
        return turmaRepository.save(turmaSalva);
    }
    
    @Override
    public void excluir(Long id) {
        turmaRepository.deleteById(id);
    }
        
}
