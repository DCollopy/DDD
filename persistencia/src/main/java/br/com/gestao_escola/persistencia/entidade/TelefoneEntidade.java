package br.com.gestao_escola.persistencia.entidade;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Data
@Table(name = "telefone")
public class TelefoneEntidade implements Serializable {

    @Column(length = 2)
    private String ddd;
    @Column(length = 11)
    private String numero_telefone;

    public TelefoneEntidade(String ddd, String numero_telefone) {
        this.ddd = ddd;
        this.numero_telefone = numero_telefone;
    }

    public TelefoneEntidade() {
    }
}
