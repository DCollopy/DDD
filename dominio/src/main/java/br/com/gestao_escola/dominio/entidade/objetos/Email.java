package br.com.gestao_escola.dominio.entidade.objetos;

import lombok.Data;

import java.util.logging.Logger;
@Data
public class Email {

    private String email;

    public Email() {
    }
    public Email(String email) {
        if (email == null || email.isEmpty()) {
            Logger.getLogger("Email").info("Email não pode ser nulo ou vazio");
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }

        if (!email.contains("@")) {
            Logger.getLogger("Email").info("Email deve conter @");
            throw new IllegalArgumentException("Email deve conter @");
        }

        this.email = email;
    }
}
