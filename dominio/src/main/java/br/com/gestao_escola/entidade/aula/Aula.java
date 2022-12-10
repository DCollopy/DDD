package br.com.gestao_escola.entidade.aula;

import lombok.Data;

@Data
public class Aula {

    private float id;

    private String nome;

    private String descricao;

    private String data_inicio;

    private String data_fim;

    private String hora_inicio;

    private String hora_fim;

    private String dia_semana;

    private String status;

    private final double limite_faltas = 0.8;

    public Aula(String nome, String descricao, String data_inicio, String data_fim, String hora_inicio, String hora_fim, String dia_semana, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
        this.dia_semana = dia_semana;
        this.status = status;
    }


}
