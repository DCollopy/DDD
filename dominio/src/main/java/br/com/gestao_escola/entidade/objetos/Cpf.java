package br.com.gestao_escola.entidade.objetos;

import lombok.Data;

import java.util.logging.Logger;


@Data
public class Cpf {

    private String numero;

    public Cpf(String numero) {
        if (numero == null || !numero.matches("^(\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2})$"))
        {
            Logger.getLogger("CPF").info("CPF invalido");
            throw new IllegalArgumentException("CPF invalido");
        }
        this.numero = numero;
    }
}
