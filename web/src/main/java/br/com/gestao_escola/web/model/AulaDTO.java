package br.com.gestao_escola.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data

public class AulaDTO {

    private String nome;

    private String descricao;

    private LocalDate data_inicio;

    private LocalDate data_fim;

    private LocalTime hora_inicio;

    private LocalTime hora_fim;

    private String dia_semana;

    private String dia_semana_2;

    private String dia_semana_3;

    private Boolean aulaAtiva;

    private double limite_faltas;

    public AulaDTO(){}
}
