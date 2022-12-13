package br.com.gestao_escola.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data
@Table(name = "responsavel")
public class ResponsavelEntidade extends PessoaEntidade implements Serializable {
    private String perfil;

    @ManyToOne
    private AlunoEntidade aluno;
}
