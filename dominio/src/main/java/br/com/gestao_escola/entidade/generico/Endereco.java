package br.com.gestao_escola.entidade.generico;

import lombok.Data;

@Data
public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private Cep cep;

    public Endereco(String rua, String numero, String bairro, String cidade, String estado, Cep cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}
