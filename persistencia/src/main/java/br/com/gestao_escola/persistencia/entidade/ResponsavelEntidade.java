package br.com.gestao_escola.persistencia.entidade;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Data
@Table(name = "responsavel")
public class ResponsavelEntidade extends PessoaEntidade implements Serializable {

    private String perfil;

    public ResponsavelEntidade() {
    }

    public ResponsavelEntidade(String nome, String sobrenome, TelefoneEntidade telefone
            , EnderecoEntidade endereco, CpfEntidade cpf, EmailEntidade email) {
        super(nome, sobrenome, telefone, endereco, cpf, email);
    }
}
