package br.com.gestao_escola.dominio.entidade.disciplina;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Turma {

    private int id;

    private String nome;

    private String descricao;

    private LocalDate data_inicio;

    private LocalDate data_fim;

    private List<Aluno> aluno;

    private final int limite_alunos = 30;

    private int quantidade_alunos;

    private float media_turma;

    private boolean turmaAtiva;

    public Turma() {
    }

    public Turma(String nome, String descricao, LocalDate data_inicio, LocalDate data_fim) {

        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome da turma não pode ser nulo ou vazio");
        }
        if (data_inicio == null) {
            throw new IllegalArgumentException("Data de inicio da turma não pode ser nula ou vazia");
        }
        if (data_fim == null) {
            throw new IllegalArgumentException("Data de fim da turma não pode ser nula ou vazia");
        }

        if(data_inicio.isAfter(data_fim)){
            throw new IllegalArgumentException("Data de inicio da turma não pode ser maior que a data de fim");
        }

        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }

    public Turma(float media_turma) {
        this.media_turma = media_turma;
    }

    public Turma(int quantidade_alunos) {
        quantidade_alunos += 1;
        if (quantidade_alunos > limite_alunos) {
            throw new IllegalArgumentException("Limite de alunos excedido");
        }
        this.quantidade_alunos = quantidade_alunos;
    }
}