package br.com.gestao_escola.web.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ForumDTO<T> {

    private float id;

    private String mensagem;

    private  T identidade;

    private LocalDate data;
}
