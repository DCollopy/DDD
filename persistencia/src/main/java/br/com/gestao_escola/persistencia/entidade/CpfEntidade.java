package br.com.gestao_escola.persistencia.entidade;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Data
@Table(name = "cpf")
public class CpfEntidade implements Serializable {
    protected CpfEntidade() {}
    public CpfEntidade(String cpf) {
        this.cpf = cpf;
    }
    @Column(length = 11, nullable = false)
    private String cpf;
}
