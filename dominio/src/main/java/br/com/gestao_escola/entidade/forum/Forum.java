package br.com.gestao_escola.entidade.forum;

import lombok.Data;

import java.time.LocalDate;
import java.util.stream.Collector;

@Data
public class Forum<T>{

    private float id;

    private String mensagem;

    private  T identidade;

    private final  LocalDate data = LocalDate.now();

    public Forum(String mensagem, T identidade) {

        if(mensagem == null || mensagem.isEmpty()) {
            throw new IllegalArgumentException("Mensagem não pode ser nula ou vazia");
        }

        if(identidade == null ) {
            throw new IllegalArgumentException("Identidade não pode ser nula ou vazia");
        }

        if(mensagem.length() > 500) {
            throw new IllegalArgumentException("Mensagem não pode ter mais de 500 caracteres");
        }
        this.mensagem = mensagem;
        this.identidade = identidade;
    }
}
