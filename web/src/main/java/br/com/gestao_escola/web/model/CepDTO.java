package br.com.gestao_escola.web.model;

import br.com.gestao_escola.dominio.entidade.objetos.Cep;
import lombok.Data;

@Data
public class CepDTO {
    private String cep;

    public Cep converteDtoParaCep() {
        return new Cep(this.getCep());
    }
}
