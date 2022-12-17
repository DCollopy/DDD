package br.com.gestao_escola.web.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class EnderecoDTO {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private CepDTO cep;

    public EnderecoDTO() {
    }
}