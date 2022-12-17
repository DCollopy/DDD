package br.com.gestao_escola.dominio.entidade.objetos;

import lombok.Data;

import java.util.logging.Logger;
@Data
public class Cep {
    private String numero_cep;

    public Cep() {
    }

    public Cep(String numero_cep) {
        if (numero_cep == null || !numero_cep.matches("^(\\d{5}-\\d{3})$"))
        {
            Logger.getLogger("CEP").info("CEP invalido");
            throw new IllegalArgumentException("CEP invalido");
        }
        this.numero_cep = numero_cep;
    }
}
