package com.github.kpossoli.projetopcp.service;

import com.github.kpossoli.projetopcp.model.Docente;
import java.util.List;

public interface DocenteService {

    Docente obterDocente(Long id);

    List<Docente> listarDocentes();

    Docente criarDocente(Docente docente);
    
    Docente atualizarDocente(Long id, Docente docente);
    
    void excluirDocente(Long id);

}
