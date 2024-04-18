package com.github.kpossoli.projetopcp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.github.kpossoli.projetopcp.model.Docente;
import com.github.kpossoli.projetopcp.repository.DocenteRepository;
import com.github.kpossoli.projetopcp.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public Docente obterDocente(Long id) {
        return docenteRepository.findById(id)
            .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public List<Docente> listarDocentes() {
        return docenteRepository.findAll();
    }

    @Override
    public Docente criarDocente(Docente docente) {
        var usuario = usuarioRepository.findById(docente.getUsuario().getId())
            .orElseThrow(() -> new EmptyResultDataAccessException(1));
            
        docente.setUsuario(usuario);

        return docenteRepository.save(docente);
    }
    
    @Override
    public Docente atualizarDocente(Long id, Docente docente) {
        Docente docenteSalvo = obterDocente(id);
		BeanUtils.copyProperties(docente, docenteSalvo, "id");
        return docenteRepository.save(docente);
    }
    
    @Override
    public void excluirDocente(Long id) {
        docenteRepository.deleteById(id);
    }
        
}
