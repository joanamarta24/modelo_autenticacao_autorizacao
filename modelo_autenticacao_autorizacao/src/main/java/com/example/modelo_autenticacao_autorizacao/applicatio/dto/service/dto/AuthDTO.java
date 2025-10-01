package com.example.modelo_autenticacao_autorizacao.applicatio.dto.service.dto;

public class AuthDTO {

    public record LoginRequest(
            String email,
            String senha
    ) {}
    public record TokenResponse(
            String token
    ) {}
}