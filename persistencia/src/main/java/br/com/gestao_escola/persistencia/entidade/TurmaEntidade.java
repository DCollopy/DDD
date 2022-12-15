package br.com.gestao_escola.persistencia.entidade;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "turma")
public class TurmaEntidade  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private float id;

    private String nome;

    private String descricao;

    private LocalDate data_inicio;

    private LocalDate data_fim;

    @ManyToMany
    private Set<AlunoEntidade> aluno;

    private int limite_alunos;

    private int quantidade_alunos;

    private float media_turma;

    private boolean turmaAtiva;

    protected TurmaEntidade() {}

}
