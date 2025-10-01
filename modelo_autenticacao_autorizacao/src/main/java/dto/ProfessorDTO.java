package dto;

public record ProfessorDTO(
        String nome
) {
    public static ProfessorDTO fromEntity(Professor professor) {
        return new ProfessorDTO(professor.getNome())
    }
}