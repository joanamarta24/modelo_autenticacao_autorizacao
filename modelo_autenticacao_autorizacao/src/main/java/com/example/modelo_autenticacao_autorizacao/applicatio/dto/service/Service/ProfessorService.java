package com.example.modelo_autenticacao_autorizacao.applicatio.dto.service.Service;

import dto.ProfessorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<ProfessorDTO> listarTodosProfessores() {
        return professorRepository.findAll().stream()
                .map(ProfessorDTO::fromEntity)
                .toList();
    }
}