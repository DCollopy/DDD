package br.com.gestao_escola.persistencia.entidade;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Data
@Table(name = "aula")
public class AulaEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private double limite_faltas;

    protected AulaEntidade() {}

}
