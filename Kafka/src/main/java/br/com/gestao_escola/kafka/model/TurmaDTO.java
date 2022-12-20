package br.com.gestao_escola.kafka.model;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TurmaDTO {

    private String nome;

    private String descricao;

    private LocalDate data_inicio;

    private LocalDate data_fim;

    private List<AlunoDTO> aluno;

    private int quantidade_alunos;

    private float media_turma;

    private boolean status;

    public TurmaDTO() {
    }
}