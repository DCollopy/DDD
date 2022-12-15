package br.com.gestao_escola.persistencia.entidade;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "professor")
public class ProfessorEntidade extends PessoaEntidade implements Serializable {

    private String perfil;

    private String matricula;

    @OneToMany
    private Set<DisciplinaEntidade> disciplina;

    protected ProfessorEntidade() {}

}
