package br.com.gestao_escola.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForumDTO<T> {

    private String mensagem;

    private  T identidade;

    private LocalDate data;
}
