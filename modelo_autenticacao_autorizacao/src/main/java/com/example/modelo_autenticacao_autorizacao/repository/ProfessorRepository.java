package com.example.modelo_autenticacao_autorizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor,String> {
    Optional<Professor> findByEmail(String email);
}
