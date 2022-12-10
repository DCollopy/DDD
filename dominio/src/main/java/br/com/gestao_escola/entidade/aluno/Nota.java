package br.com.gestao_escola.entidade.aluno;

import br.com.gestao_escola.entidade.aula.Aula;
import lombok.Data;

@Data
public class Nota {

    private float id;
    private double nota;
    private Aula aula;
    private Aluno aluno;

    public Nota(double nota, Aula aula, Aluno aluno) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota invalida");
        }
        if (aula == null) {
            throw new IllegalArgumentException("Aula invalida");
        }
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno invalido");
        }

        this.nota = nota;
        this.aula = aula;
        this.aluno = aluno;
    }
}
