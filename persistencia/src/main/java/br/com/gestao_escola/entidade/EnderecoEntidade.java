package br.com.gestao_escola.entidade;

import br.com.gestao_escola.entidade.objetos.Cep;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
@Table(name = "endereco")
public class EnderecoEntidade implements Serializable {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private CepEntidade cep;
}
