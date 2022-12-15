package br.com.gestao_escola.persistencia.entidade;


import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Table;
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

    public EnderecoEntidade(String rua, String num, String bairro, String cidade, String estado, CepEntidade cep) {
        this.rua = rua;
        this.num = num;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public EnderecoEntidade() {
    }
}
