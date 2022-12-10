package br.com.gestao_escola.entidade.generico;

public class Email {

    private String email;

    public Email(String email) {

        if(email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }

        if(!email.contains("@")) {
            throw new IllegalArgumentException("Email deve conter @");
        }

        this.email = email;
    }
}
