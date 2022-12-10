package br.com.gestao_escola.entidade.objetos;

import lombok.Data;

@Data
public class Telefone {

    private String numero;
    private String ddd;


    public Telefone(String ddd, String numero) {

        if(numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("Numero não pode ser nulo ou vazio");
        }

        if(ddd == null || ddd.isEmpty()) {
            throw new IllegalArgumentException("DDD não pode ser nulo ou vazio");
        }

        if(!numero.matches("^(\\d{4}-?\\d{4})$")) {
            throw new IllegalArgumentException("Numero invalido");
        }

        if(!ddd.matches("^(\\d{2})$")) {
            throw new IllegalArgumentException("DDD invalido");
        }
        this.numero = numero;
        this.ddd = ddd;
    }

}
