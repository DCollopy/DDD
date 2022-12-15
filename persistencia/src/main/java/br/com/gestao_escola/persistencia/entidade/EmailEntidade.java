package br.com.gestao_escola.persistencia.entidade;


import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;
@Embeddable
@Data
@Table(name = "email")
public class EmailEntidade implements Serializable {

    private String email;

    public EmailEntidade(String email) {
        this.email = email;
    }

    public EmailEntidade() {
    }
}
