package com.example.modelo_autenticacao_autorizacao.applicatio.dto.service.entity;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name="professores")
public class Professor extends Usuario {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="professor_turmas", joinColumns=@JoinColumn(name="professor_id"))
    @Column(name="turma")
    private List<String > listaDeTurmas;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="professor_ucs", joinColumns=@JoinColumn(name="professor_id"))
    @Column(name="uc")
    private List<String> listaDeUC;
}