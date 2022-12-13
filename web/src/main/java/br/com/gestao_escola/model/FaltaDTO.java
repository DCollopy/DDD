package br.com.gestao_escola.model;

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

    public FaltaDTO(AlunoDTO aluno, AulaDTO aula,  String justificativa){
        this.aluno = aluno;
        this.aula = aula;
        this.numeroFaltas = numeroFaltas;
    }

    public FaltaDTO(AlunoDTO aluno, AulaDTO aula){
        this.aluno = aluno;
        this.aula = aula;
    }
}
