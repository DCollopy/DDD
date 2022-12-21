package br.com.gestao_escola.kafka.model;

import lombok.Data;

@Data
public class NotaDTO {

    private double nota_1;

    private double nota_2;

    private double nota_3;

    private AulaDTO aula;

    private AlunoDTO aluno;

    private double media;
}