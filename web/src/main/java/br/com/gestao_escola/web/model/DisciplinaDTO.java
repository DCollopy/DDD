package br.com.gestao_escola.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DisciplinaDTO {

    private AulaDTO aula;

    private TurmaDTO turma;

    private ProfessorDTO professor;
}