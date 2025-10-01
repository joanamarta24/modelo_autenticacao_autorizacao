package com.example.modelo_autenticacao_autorizacao.repository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}
