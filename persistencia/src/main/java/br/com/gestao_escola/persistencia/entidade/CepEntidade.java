package br.com.gestao_escola.persistencia.entidade;


import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Data
@Table(name = "cep")
public class CepEntidade implements Serializable {

    private String numero_cep;

    public CepEntidade(String numero_cep) {
        this.numero_cep = numero_cep;
    }

    public CepEntidade() {
    }
}

