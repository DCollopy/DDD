package br.com.gestao_escola.entidade.objetos;

import lombok.Data;

import java.util.logging.Logger;

@Data
public class Telefone {

    private String numero;
    private String ddd;


    public Telefone(String ddd, String numero) {

        if (numero == null || numero.isEmpty()) {
            Logger.getLogger("Telefone").info("Numero não pode ser nulo ou vazio");
            throw new IllegalArgumentException("Numero não pode ser nulo ou vazio");
        }

        if (ddd == null || ddd.isEmpty()) {
            Logger.getLogger("Telefone").info("DDD não pode ser nulo ou vazio");
            throw new IllegalArgumentException("DDD não pode ser nulo ou vazio");
        }

        if (!numero.matches("^(\\d{4}-?\\d{4})$")) {
            Logger.getLogger("Telefone").info("Numero invalido");
            throw new IllegalArgumentException("Numero invalido");
        }

        if (!ddd.matches("^(\\d{2})$")) {
            Logger.getLogger("Telefone").info("DDD invalido");
            throw new IllegalArgumentException("DDD invalido");
        }
        this.numero = numero;
        this.ddd = ddd;
    }

}
