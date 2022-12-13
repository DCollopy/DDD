package br.com.gestao_escola.web.model;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.dominio.entidade.disciplina.Turma;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TurmaDTO {

    private String nome;

    private String descricao;

    private LocalDate data_inicio;

    private LocalDate data_fim;

    private List<Aluno> aluno;

    private int quantidade_alunos;

    private float media_turma;

    private boolean status;

    public Turma converteDtoParaTurma() {
        return new Turma(this.getNome()
                , this.getDescricao()
                , this.getData_inicio()
                , this.getData_fim()
        );
    }
}
