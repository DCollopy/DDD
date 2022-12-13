package br.com.gestao_escola.persistencia.entidade;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
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
}
