package br.com.gestao_escola.web.model;

import br.com.gestao_escola.dominio.entidade.aula.Aula;
import br.com.gestao_escola.dominio.entidade.disciplina.Turma;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DisciplinaDTO {

    private float id;

    private Aula aula;

    private Turma turma;

    private ProfessorDTO professor;
}