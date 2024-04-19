package com.github.kpossoli.projetopcp.service;

import com.github.kpossoli.projetopcp.repository.PapelRepository;
import com.github.kpossoli.projetopcp.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.github.kpossoli.projetopcp.model.Usuario;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PapelRepository papelRepository;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        var papel = papelRepository.findById(usuario.getPapel().getId())
            .orElseThrow(RuntimeException::new);

        usuario.setPapel(papel);

        return usuarioRepository.save(usuario);
    }
    
}
