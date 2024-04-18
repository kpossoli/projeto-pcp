package com.github.kpossoli.projetopcp.service;

import com.github.kpossoli.projetopcp.repository.PapelRepository;
import com.github.kpossoli.projetopcp.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.kpossoli.projetopcp.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PapelRepository papelRepository;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        var papel = papelRepository.findById(usuario.getPapel().getId())
            .orElseThrow(RuntimeException::new);

        usuario.setPapel(papel);

        return usuarioRepository.save(usuario);
    }
    
}
