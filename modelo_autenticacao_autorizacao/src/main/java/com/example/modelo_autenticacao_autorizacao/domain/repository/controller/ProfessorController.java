package com.example.modelo_autenticacao_autorizacao.domain.repository.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService service;

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> listarTodosProfessores() {
        List<ProfessorDTO> professores = service.listarTodosProfessores();
        return ResponseEntity.ok(professores);
    }
}