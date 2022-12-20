package br.com.gestao_escola.persistencia.entidade;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;


@Entity
@Data
@Table(name = "aluno")
public class AlunoEntidade extends PessoaEntidade implements Serializable {
    private String matricula;

    private String perfil;

    @ManyToMany
    private Set<FaltaEntidade> falta;

    @ManyToMany
    private Set<TurmaEntidade> turma;

    @OneToOne
    private ResponsavelEntidade responsavel;

    public AlunoEntidade() {
        super();
    }
}