package com.github.kpossoli.projetopcp.controller;

import org.springframework.web.bind.annotation.*;

import com.github.kpossoli.projetopcp.dto.DocenteDto;
import com.github.kpossoli.projetopcp.mapper.DocenteMapper;
import com.github.kpossoli.projetopcp.model.Docente;
import com.github.kpossoli.projetopcp.service.DocenteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/docentes")
public class DocenteController {

    private final DocenteService docenteService;
    private final DocenteMapper docenteMapper;

    @GetMapping("/{id}")
    public ResponseEntity<DocenteDto> obter(@PathVariable Long id) {
        Docente docente = docenteService.obter(id);
        DocenteDto docenteDto = docenteMapper.toDto(docente);

        return ResponseEntity.ok(docenteDto);
    }

    @GetMapping
    public ResponseEntity<List<DocenteDto>> listar() {
        List<Docente> docentes = docenteService.listar();
        List<DocenteDto> docentesDto = docenteMapper.toDto(docentes);

        return ResponseEntity.ok(docentesDto);
    }

    @PostMapping
    public ResponseEntity<DocenteDto> criar(@RequestBody @Valid DocenteDto docenteDto) {
        Docente docente = docenteMapper.toEntity(docenteDto);
        Docente docenteSalvo = docenteService.criar(docente);
        DocenteDto docenteSalvoDto = docenteMapper.toDto(docenteSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(docenteSalvoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocenteDto> atualizar(@PathVariable Long id, @RequestBody @Valid DocenteDto docenteDto) {
        Docente docente = docenteMapper.toEntity(docenteDto);
        Docente docenteSalvo = docenteService.atualizar(id, docente);
        DocenteDto docenteSalvoDto = docenteMapper.toDto(docenteSalvo);

        return ResponseEntity.ok(docenteSalvoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        docenteService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}

