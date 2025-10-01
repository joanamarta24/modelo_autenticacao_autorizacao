package com.example.modelo_autenticacao_autorizacao.infrastructure.config.config;

import com.example.modelo_autenticacao_autorizacao.domain.repository.enums.Role;
import com.example.modelo_autenticacao_autorizacao.domain.repository.repository.ProfessorRepository;
import com.example.modelo_autenticacao_autorizacao.applicatio.dto.service.entity.Professor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminBootstrap implements CommandLineRunner {

    private final ProfessorRepository professorRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${sistema.admin.email}")
    private String adminEmail;

    @Value("${sistema.admin.senha}")
    private String adminSenha;

    @Override
    public void run(String... args) {
        professorRepository.findByEmail(adminEmail).ifPresentOrElse(
                prof -> {
                    if (!prof.isAtivo()) {
                        prof.setAtivo(true); // reativa se estava desativado
                        professorRepository.save(prof);
                    }
                },
                () -> {
                    Professor admin = Professor.builder()
                            .nome("Administrador Provisório")
                            .email(adminEmail)
                            .cpf("000.000.000-00")
                            .senhaHash(passwordEncoder.encode(adminSenha))
                            .role(Role.ADMIN) // Enum ADMIN
                            .build();
                    professorRepository.save(admin);
                    System.out.println("⚡ Usuário admin provisório criado: " + adminEmail);
                }
        );
    }
}