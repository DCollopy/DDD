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
    private float id;

    private double nota;

    @OneToOne
    private AulaEntidade aula;

    @OneToOne
    private AlunoEntidade aluno;

    private double media;

    protected NotaEntidade() {
    }
}
