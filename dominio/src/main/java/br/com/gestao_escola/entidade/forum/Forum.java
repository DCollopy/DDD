package br.com.gestao_escola.entidade.forum;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Forum {

    private float id;

    private String mensagem;

    private  String identidade;

    private final  LocalDate data = LocalDate.now();

    public Forum(String mensagem, String identidade) {

        if(mensagem == null || mensagem.isEmpty()) {
            throw new IllegalArgumentException("Mensagem não pode ser nula ou vazia");
        }

        if(identidade == null || identidade.isEmpty()) {
            throw new IllegalArgumentException("Identidade não pode ser nula ou vazia");
        }

        if(mensagem.length() > 500) {
            throw new IllegalArgumentException("Mensagem não pode ter mais de 500 caracteres");
        }
        this.mensagem = mensagem;
        this.identidade = identidade;
    }
}
