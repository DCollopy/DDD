package br.com.gestao_escola.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotaDTO {

    private int id;

    private double nota;

    private AulaDTO aula;

    private AlunoDTO aluno;

    private double media;

    public NotaDTO() {
    }
}