package br.com.gestao_escola.persistencia.entidade;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
@Table(name = "endereco")
public class EnderecoEntidade implements Serializable {

    private String rua;
    private String num;
    private String bairro;
    private String cidade;
    private String estado;
    private CepEntidade cep;
}
