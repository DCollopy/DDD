package br.com.gestao_escola.entidade.disciplina;

import br.com.gestao_escola.entidade.aula.Aula;
import br.com.gestao_escola.entidade.professor.Professor;
import lombok.Data;

@Data
public class Disciplina {

    private float id;

    private Aula aula;

    private Turma turma;

    private Professor professor;
    public Disciplina() {}

    public Disciplina(Aula aula, Turma turma, Professor professor) {
        if (aula == null) {
            throw new IllegalArgumentException("Aula invalida");
        }
        if (turma == null) {
            throw new IllegalArgumentException("Turma invalida");
        }
        if (professor == null) {
            throw new IllegalArgumentException("Professor invalido");
        }
        this.aula = aula;
        this.turma = turma;
        this.professor = professor;
    }

}
