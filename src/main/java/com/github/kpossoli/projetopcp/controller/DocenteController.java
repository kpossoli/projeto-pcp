package com.github.kpossoli.projetopcp.controller;

import org.springframework.web.bind.annotation.*;

import com.github.kpossoli.projetopcp.dto.DocenteDto;
import com.github.kpossoli.projetopcp.mapper.DocenteMapper;
import com.github.kpossoli.projetopcp.model.Docente;
import com.github.kpossoli.projetopcp.service.DocenteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/docentes")
public class DocenteController {

    private final DocenteService docenteService;
    private final DocenteMapper docenteMapper;

    @GetMapping("/{id}")
    public ResponseEntity<DocenteDto> obterDocente(@PathVariable Long id) {
        Docente docente = docenteService.obterDocente(id);
        DocenteDto docenteDto = docenteMapper.toDto(docente);
        return ResponseEntity.ok(docenteDto);
    }

    @GetMapping
    public ResponseEntity<List<DocenteDto>> listarDocentes() {
        List<Docente> docentes = docenteService.listarDocentes();
        List<DocenteDto> docentesDto = docenteMapper.toDto(docentes);
        return ResponseEntity.ok(docentesDto);
    }

    @PostMapping
    public ResponseEntity<DocenteDto> criarDocente(@RequestBody @Valid DocenteDto docenteDto) {
        Docente docente = docenteMapper.toEntity(docenteDto);
        Docente docenteSalvo = docenteService.criarDocente(docente);
        DocenteDto docenteSalvoDto = docenteMapper.toDto(docenteSalvo);
        return ResponseEntity.ok(docenteSalvoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocenteDto> atualizarDocente(@PathVariable Long id, @RequestBody @Valid DocenteDto docenteDto) {
        Docente docente = docenteMapper.toEntity(docenteDto);
        Docente docenteSalvo = docenteService.atualizarDocente(id, docente);
        DocenteDto docenteSalvoDto = docenteMapper.toDto(docenteSalvo);
        return ResponseEntity.ok(docenteSalvoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDocente(@PathVariable Long id) {
        docenteService.excluirDocente(id);
        return ResponseEntity.noContent().build();
    }
}

