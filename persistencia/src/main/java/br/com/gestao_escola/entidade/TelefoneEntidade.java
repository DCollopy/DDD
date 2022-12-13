package br.com.gestao_escola.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
@Table(name = "telefone")
public class TelefoneEntidade implements Serializable {

    @Column(length = 2)
    private String ddd;
    @Column(length = 11)
    private String numero;

}
