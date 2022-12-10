package br.com.gestao_escola.entidade.disciplina;

import br.com.gestao_escola.entidade.aula.Aula;
import lombok.Data;

@Data
public class Disciplina {

    private float id;

    private Aula aula;

    private Turma turma;

    public Disciplina() {}

    public Disciplina(Aula aula, Turma turma) {
        this.aula = aula;
        this.turma = turma;
    }

}
