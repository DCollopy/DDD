package br.com.gestao_escola.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotaDTO {

    private int id;

    private double nota_1;

    private double nota_2;

    private double nota_3;

    private AulaDTO aula;

    private AlunoDTO aluno;

    private double media;

    public NotaDTO() {
    }
}