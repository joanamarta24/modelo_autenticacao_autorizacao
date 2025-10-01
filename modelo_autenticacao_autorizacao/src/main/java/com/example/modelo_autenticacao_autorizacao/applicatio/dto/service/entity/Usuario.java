package com.example.modelo_autenticacao_autorizacao.applicatio.dto.service.entity;

import com.example.modelo_autenticacao_autorizacao.domain.repository.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) // estratégia JOINED
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected String id;

    @NotBlank
    @Column(nullable = false)
    protected String nome;

    @NotBlank
    @Column(nullable = false, unique = true, length = 14)
    protected String cpf; // formato "000.000.000-00" (validação pode ser ampliada)

    // Campos de autenticação
    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    protected String email;

    @Column(nullable = false)
    protected boolean ativo = true;

    @NotBlank
    @Column(nullable = false)
    protected String senhaHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Role role;
}