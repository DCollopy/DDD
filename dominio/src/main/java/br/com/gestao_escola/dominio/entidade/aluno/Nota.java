package br.com.gestao_escola.dominio.entidade.aluno;

import br.com.gestao_escola.dominio.entidade.aula.Aula;
import lombok.Data;

import java.util.logging.Logger;

@Data
public class Nota {

    private float id;
    private double nota;
    private Aula aula;
    private Aluno aluno;

    private double media;
    public Nota(double nota, Aula aula, Aluno aluno) {
        if (nota < 0 || nota > 10) {
            Logger.getLogger("Nota").info("Nota invalido");
            throw new IllegalArgumentException("Nota invalida");
        }
        if (aula == null) {
            Logger.getLogger("Nota").info("Aula invalido");
            throw new IllegalArgumentException("Aula invalida");
        }
        if (aluno == null) {
            Logger.getLogger("Nota").info("Aluno invalido");
            throw new IllegalArgumentException("Aluno invalido");
        }
        this.nota = nota;
        this.aula = aula;
        this.aluno = aluno;
    }

    public Nota() {
    }
}
