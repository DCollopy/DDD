package br.com.gestao_escola.dominio.entidade.objetos;

import lombok.Data;

import java.util.logging.Logger;


@Data
public class Cpf {

    private String cpf;

    public Cpf() {
    }
    public Cpf(String cpf) {
        if (cpf == null || !cpf.matches("^(\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2})$"))
        {
            Logger.getLogger("CPF").info("CPF invalido");
            throw new IllegalArgumentException("CPF invalido");
        }
        this.cpf = cpf;
    }
}
