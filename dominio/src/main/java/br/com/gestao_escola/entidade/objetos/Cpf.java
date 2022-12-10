package br.com.gestao_escola.entidade.objetos;

import lombok.Data;


@Data
public class Cpf {

    private String numero;

    public Cpf(String numero) {
        if (numero == null || !numero.matches("^(\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2})$"))
        {
            throw new IllegalArgumentException("CPF invalido");
        }
        this.numero = numero;
    }
}
