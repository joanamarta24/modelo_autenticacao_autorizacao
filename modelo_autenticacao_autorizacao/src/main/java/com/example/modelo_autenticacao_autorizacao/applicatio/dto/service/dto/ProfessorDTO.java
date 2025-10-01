package com.example.modelo_autenticacao_autorizacao.applicatio.dto.service.dto;

public record ProfessorDTO(
        String nome
) {
    public static ProfessorDTO fromEntity(Professor professor) {
        return new ProfessorDTO(professor.getNome())
    }
}