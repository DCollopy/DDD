package br.com.gestao_escola.dominio.entidade.aula;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Aula {

    private float id;

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

    private final double limite_faltas = 0.8;

    public Aula(String nome, String descricao, LocalDate data_inicio, LocalDate data_fim, LocalTime hora_inicio,
                LocalTime hora_fim, String dia_semana, String dia_semana_2, String dia_semana_3, Boolean aulaAtiva) {
        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
        this.dia_semana = dia_semana;
        this.dia_semana_2 = dia_semana_2;
        this.dia_semana_3 = dia_semana_3;
        this.aulaAtiva = aulaAtiva;
    }
}
