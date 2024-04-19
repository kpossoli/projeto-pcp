package com.github.kpossoli.projetopcp.controller;

import com.github.kpossoli.projetopcp.dto.UsuarioDto;
import com.github.kpossoli.projetopcp.mapper.UsuarioMapper;
import com.github.kpossoli.projetopcp.model.Usuario;
import com.github.kpossoli.projetopcp.security.Autorizacao;
import com.github.kpossoli.projetopcp.security.RespostaJWT;
import com.github.kpossoli.projetopcp.security.JwtService;
import com.github.kpossoli.projetopcp.service.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;


@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    @PreAuthorize("hasAuthority('USUARIO_WRITE')")
    public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        Usuario usuarioSalvo = usuarioService.criarUsuario(usuario);
        UsuarioDto usuarioSalvoDto = usuarioMapper.toDto(usuarioSalvo);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvoDto);
    }

    @PostMapping("/login")
    public RespostaJWT login(@RequestBody Autorizacao authRequestDTO){
        var auth = new UsernamePasswordAuthenticationToken(authRequestDTO.getUsuario(), authRequestDTO.getSenha());
        Authentication authentication = authenticationManager.authenticate(auth);

        if(authentication.isAuthenticated()){
            return RespostaJWT.builder()
                    .accessToken(jwtService.gerarToken(authRequestDTO.getUsuario()))
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuário Não encontrado!");
        }
    }

}