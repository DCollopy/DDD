package br.com.gestao_escola.kafka.model;

import lombok.Data;

@Data
public class NotaDTO {

    private double nota;

    private AulaDTO aula;

    private AlunoDTO aluno;

    private double media;
}