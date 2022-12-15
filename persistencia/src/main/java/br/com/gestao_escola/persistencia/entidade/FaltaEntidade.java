package br.com.gestao_escola.persistencia.entidade;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "falta")
public class FaltaEntidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private float id;

    @ManyToMany
    private Set<AlunoEntidade> aluno;

    @OneToOne
    private AulaEntidade aula;

    private int numeroFaltas;

    private int numeroPresenca;

    private LocalDate falta_data;

    private LocalDate presenca;

    private String justificativa;

    public int totalPreenca;

    public int totalFaltas;

    protected FaltaEntidade() {}

}
