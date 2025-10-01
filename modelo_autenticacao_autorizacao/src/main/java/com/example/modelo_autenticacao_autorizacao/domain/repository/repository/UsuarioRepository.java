package com.example.modelo_autenticacao_autorizacao.domain.repository.repository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}
