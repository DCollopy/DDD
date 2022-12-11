package br.com.gestao_escola.entidade.disciplina;

import br.com.gestao_escola.entidade.aula.Aula;
import br.com.gestao_escola.entidade.professor.Professor;
import lombok.Data;

import java.util.logging.Logger;

@Data
public class Disciplina {

    private float id;

    private Aula aula;

    private Turma turma;

    private Professor professor;
    public Disciplina() {}

    public Disciplina(Aula aula, Turma turma, Professor professor) {
        if (aula == null) {
            Logger.getLogger("Disciplina").info("Aula nao pode ser nula");
            throw new IllegalArgumentException("Aula invalida");
        }
        if (turma == null) {
            Logger.getLogger("Disciplina").info("Turma nao pode ser nula");
            throw new IllegalArgumentException("Turma invalida");
        }
        if (professor == null) {
            Logger.getLogger("Disciplina").info("Professor nao pode ser nulo");
            throw new IllegalArgumentException("Professor invalido");
        }
        this.aula = aula;
        this.turma = turma;
        this.professor = professor;
    }

    public Disciplina(float id, Aula aula, Turma turma, Professor professor) {
        if (aula == null) {
            throw new IllegalArgumentException("Aula invalida");
        }
        if (turma == null) {
            throw new IllegalArgumentException("Turma invalida");
        }
        if (professor == null) {
            throw new IllegalArgumentException("Professor invalido");
        }
        this.id = id;
        this.aula = aula;
        this.turma = turma;
        this.professor = professor;
    }
}
