package br.com.gestao_escola.kafka.model;


import lombok.Data;

@Data
public class DisciplinaDTO {


    private AulaDTO aula;

    private TurmaDTO turma;

    private ProfessorDTO professor;
}