package br.com.gestao_escola.entidade.aluno;

import br.com.gestao_escola.entidade.aula.Aula;
import lombok.Data;

import java.time.LocalDate;
import java.util.logging.Logger;

@Data
public class Falta {

    private float id;
    //1:1
    private Aluno aluno;
    //1:1
    private Aula aula;
    private int numeroFaltas;

    private int numeroPresenca;
    private LocalDate falta_data;
    private LocalDate presenca;
    private String justificativa;

    public int totalPreenca;

    public int totalFaltas;

    public Falta(Aluno aluno, Aula aula,  String justificativa) {
        if(aluno == null){
            Logger.getLogger("Falta").info("Aluno não pode ser nulo");
            throw new IllegalArgumentException("Aluno não pode ser nulo");
        }
        if(aula == null){
            Logger.getLogger("Falta").info("Aula não pode ser nula");
            throw new IllegalArgumentException("Aula não pode ser nulo");
        }
        numeroFaltas += 1;
        LocalDate falta_data = LocalDate.now();
        this.aluno = aluno;
        this.aula = aula;
        this.numeroFaltas = numeroFaltas;
        this.justificativa = justificativa;
        this.falta_data = falta_data;
    }

    public Falta(Aluno aluno, Aula aula) {
        if(aluno == null){
            Logger.getLogger("Falta").info("Aluno não pode ser nulo");
            throw new IllegalArgumentException("Aluno não pode ser nulo");
        }
        if(aula == null){
            Logger.getLogger("Falta").info("Aula não pode ser nula");
            throw new IllegalArgumentException("Aula não pode ser nulo");
        }
        numeroPresenca += 1;
        LocalDate presenca = LocalDate.now();
        this.aluno = aluno;
        this.aula = aula;
        this.presenca = presenca;
    }
}
