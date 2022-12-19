package br.com.gestao_escola.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfessorDTO extends PessoaDTO{

    private String perfil;

    private String matricula;

    private DisciplinaDTO disciplina;

    public ProfessorDTO() {
        super();
    }
}