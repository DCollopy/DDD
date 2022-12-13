package br.com.gestao_escola.persistencia.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "aluno")
public class AlunoEntidade extends PessoaEntidade implements Serializable {

    private String matricula;

    private String perfil;

    private String turma;

    private FaltaEntidade falta;

    @OneToMany(mappedBy = "aluno")
    private Set<ResponsavelEntidade> responsavel;

    protected AlunoEntidade() {
    }

    public AlunoEntidade(String matricula, String perfil, String turma,Set<ResponsavelEntidade> responsavel) {
        this.matricula = matricula;
        this.perfil = perfil;
        this.turma = turma;
        this.falta = falta;
        this.responsavel = responsavel;
    }

    public AlunoEntidade(String matricula, String perfil, Set<ResponsavelEntidade> responsavel) {
        this.matricula = matricula;
        this.perfil = perfil;
        this.responsavel = responsavel;
    }
}
