package com.github.kpossoli.projetopcp.service;

import com.github.kpossoli.projetopcp.repository.PapelRepository;
import com.github.kpossoli.projetopcp.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.kpossoli.projetopcp.model.Usuario;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PapelRepository papelRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        var papel = papelRepository.findById(usuario.getPapel().getId())
            .orElseThrow(RuntimeException::new);

        usuario.setPapel(papel);

        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);

        return usuarioRepository.save(usuario);
    }
    
}
