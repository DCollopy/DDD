package br.com.gestao_escola.persistencia.entidade;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "disciplina")
public class DisciplinaEntidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private AulaEntidade aula;

    @OneToOne
    private TurmaEntidade turma;

    @ManyToOne
    private ProfessorEntidade professor;

    protected DisciplinaEntidade() {}
}
