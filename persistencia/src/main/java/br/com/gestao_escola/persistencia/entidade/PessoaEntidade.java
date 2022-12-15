package br.com.gestao_escola.persistencia.entidade;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.io.Serializable;

@MappedSuperclass
@Data
@Table(name = "pessoa")
public class PessoaEntidade implements Serializable {

    private String nome;

    private String sobrenome;

    private TelefoneEntidade telefone;

    private EnderecoEntidade endereco;

    @EmbeddedId
    private CpfEntidade cpf;

    private EmailEntidade email;

    public PessoaEntidade() {
    }

    public PessoaEntidade(String nome, String sobrenome, TelefoneEntidade telefone, EnderecoEntidade endereco, CpfEntidade cpf, EmailEntidade email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.email = email;
    }

    public PessoaEntidade(String nome, String sobrenome, CpfEntidade cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }
}
