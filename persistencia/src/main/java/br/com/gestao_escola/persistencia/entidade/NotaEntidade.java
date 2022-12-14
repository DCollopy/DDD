package br.com.gestao_escola.persistencia.entidade;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "nota")
public class NotaEntidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double nota_1;

    private double nota_2;

    private double nota_3;

    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
    private AulaEntidade aula;

    @OneToOne
    private AlunoEntidade aluno;

    private double media;

    protected NotaEntidade() {
    }
}
