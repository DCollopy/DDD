package br.com.gestao_escola.kafka.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FaltaDTO {

    private AlunoDTO aluno;

    private AulaDTO aula;

    private int numeroFaltas;

    private int numeroPresenca;

    private LocalDate falta_data;

    private LocalDate presenca;

    private String justificativa;

    public int totalPreenca;

    public int totalFaltas;
    public FaltaDTO(){}
}
