package br.com.gestao_escola.model;

import br.com.gestao_escola.entidade.objetos.Cep;
import lombok.Data;

@Data
public class CepDTO {
    private String cep;

    public Cep converteDtoParaCep() {
        return new Cep(this.getCep());
    }
}
