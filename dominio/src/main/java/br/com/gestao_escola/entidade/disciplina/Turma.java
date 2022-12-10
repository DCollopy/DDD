package br.com.gestao_escola.entidade.disciplina;

import br.com.gestao_escola.entidade.aluno.Aluno;
import lombok.Data;

@Data
public class Turma {

    private float id;

    private String nome;

    private String descricao;

    private String data_inicio;

    private String data_fim;

    private Aluno aluno;

    private final int limite_alunos = 30;

    private int quantidade_alunos ;

    private float media_turma;

    private boolean status;

    public Turma() {}

    public Turma(String nome, String descricao, String data_inicio, String data_fim, Aluno aluno) {

        if(nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome da turma não pode ser nulo ou vazio");
        }
        if(data_inicio == null || data_inicio.isEmpty()) {
            throw new IllegalArgumentException("Data de inicio da turma não pode ser nula ou vazia");
        }
        if(data_fim == null || data_fim.isEmpty()) {
            throw new IllegalArgumentException("Data de fim da turma não pode ser nula ou vazia");
        }


        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.aluno = aluno;
    }

    public Turma (float media_turma) {
        this.media_turma = media_turma;
    }

    public Turma (int quantidade_alunos) {
        quantidade_alunos += 1;
        if(quantidade_alunos > limite_alunos) {
            throw new IllegalArgumentException("Limite de alunos excedido");
        }
        this.quantidade_alunos = quantidade_alunos;
    }
}
