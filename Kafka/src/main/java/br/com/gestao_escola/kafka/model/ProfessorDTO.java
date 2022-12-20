package br.com.gestao_escola.kafka.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ProfessorDTO extends PessoaDTO{

    private String perfil;

    private String matricula;

    private DisciplinaDTO disciplina;

    public ProfessorDTO() {
        super();
    }
}