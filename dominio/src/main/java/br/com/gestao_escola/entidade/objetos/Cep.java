package br.com.gestao_escola.entidade.objetos;

import java.util.logging.Logger;

public class Cep {

    private String numero;

    public Cep(String numero) {
        if (numero == null || !numero.matches("^(\\d{5}-\\d{3})$"))
        {
            Logger.getLogger("CEP").info("CEP invalido");
            throw new IllegalArgumentException("CEP invalido");
        }
        this.numero = numero;
    }
}
