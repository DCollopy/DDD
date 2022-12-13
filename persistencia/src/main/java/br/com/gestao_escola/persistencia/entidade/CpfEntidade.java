package br.com.gestao_escola.persistencia.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Data;

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
