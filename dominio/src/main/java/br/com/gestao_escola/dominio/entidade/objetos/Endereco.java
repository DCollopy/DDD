package br.com.gestao_escola.dominio.entidade.objetos;

import lombok.Data;

import java.util.logging.Logger;

@Data
public class Endereco {

    private String rua;
    private String num;
    private String bairro;
    private String cidade;
    private String estado;
    private Cep cep;

    public Endereco() {
    }

    public Endereco(String rua, String num, String bairro, String cidade, String estado, Cep cep) {

        if (rua == null || rua.isEmpty()) {
            Logger.getLogger("Endereço").info("Rua invalida");
            throw new IllegalArgumentException("Rua invalida");
        }
        if (num == null || num.isEmpty()) {
            Logger.getLogger("Endereço").info("Numero invalido");
            throw new IllegalArgumentException("Numero invalido");
        }
        if (bairro == null || bairro.isEmpty()) {
            Logger.getLogger("Endereço").info("Bairro invalido");
            throw new IllegalArgumentException("Bairro invalido");
        }
        if (cidade == null || cidade.isEmpty()) {
            Logger.getLogger("Endereço").info("Cidade invalida");
            throw new IllegalArgumentException("Cidade invalida");
        }
        if (estado == null || estado.isEmpty()) {
            Logger.getLogger("Endereço").info("Estado invalido");
            throw new IllegalArgumentException("Estado invalido");
        }
        this.rua = rua;
        this.num = num;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}
