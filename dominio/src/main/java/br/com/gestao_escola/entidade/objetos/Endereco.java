package br.com.gestao_escola.entidade.objetos;

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

        if (rua == null || rua.isEmpty()) {
            throw new IllegalArgumentException("Rua invalida");
        }
        if (numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("Numero invalido");
        }
        if (bairro == null || bairro.isEmpty()) {
            throw new IllegalArgumentException("Bairro invalido");
        }
        if (cidade == null || cidade.isEmpty()) {
            throw new IllegalArgumentException("Cidade invalida");
        }
        if (estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException("Estado invalido");
        }
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}
