package br.com.gestao_escola.kafka.model;

import lombok.Data;

import java.time.LocalDate;
@Data

public class ForumDTO<T> {


    private String mensagem;

    private  T identidade;

    private LocalDate data;
}
