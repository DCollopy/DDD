package br.com.gestao_escola.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CepDTO {

    private String numero_cep;

    public CepDTO() {
    }
}