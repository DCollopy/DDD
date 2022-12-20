package br.com.gestao_escola.kafka.model;

import lombok.Data;

@Data
public class CepDTO {

    private String numero_cep;

    public CepDTO() {
    }
}