package br.com.gestao_escola.entidade;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
@Table(name = "cep")
public class CepEntidade implements Serializable {

    private String cep;
}
