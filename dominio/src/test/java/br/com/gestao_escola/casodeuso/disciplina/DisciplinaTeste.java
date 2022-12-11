package br.com.gestao_escola.casodeuso.disciplina;

import br.com.gestao_escola.entidade.aluno.Aluno;
import br.com.gestao_escola.entidade.aula.Aula;
import br.com.gestao_escola.entidade.disciplina.Disciplina;
import br.com.gestao_escola.entidade.disciplina.Turma;
import br.com.gestao_escola.entidade.objetos.*;
import br.com.gestao_escola.entidade.professor.Professor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static br.com.gestao_escola.entidade.objetos.DiaSemana.SEGUNDA;
import static br.com.gestao_escola.entidade.objetos.DiaSemana.SEXTA;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DisciplinaTeste {

    protected DisciplinaValidaTeste disciplinaValidaTeste = new DisciplinaValidaTeste();

    Aluno aluno = new Aluno("Pedro", "Silva"
            , new Telefone("22", "12345678")
            , new Endereco("x", "x", "x", "x", "x"
            , new Cep("12345-678"))
            , new Cpf("12345678910")
            , new Email("teste@email.cm"));
    Aula aula = new Aula("Matematica", "Aula de matematica"
            , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
            , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
            , SEGUNDA, SEXTA, null, TRUE);

    Turma turma = new Turma("Turma 1", "Turma de matematica"
            , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
            , aluno);

    Professor professor = new Professor("Joao", "Silva"
            , new Telefone("22", "12345678")
            , new Endereco("x", "x", "x", "x", "x"
            , new Cep("12345-678"))
            , new Cpf("12345678910")
            , new Email("teste@email.cm"));

    Disciplina disciplina = new Disciplina(aula, turma, professor);

    Disciplina disciplinaGetId = new Disciplina(1, aula, turma, professor);

    @Test
    void notProfileDisciplina() {
        assertThrows(IllegalArgumentException.class, () -> new Disciplina(null, turma, professor));

        assertThrows(IllegalArgumentException.class, () -> new Disciplina(aula, null, professor));

        assertThrows(IllegalArgumentException.class, () -> new Disciplina(aula, turma, null));
    }

    @Test
    void criaDisciplina() {
        assertNotNull(disciplina);
    }

    @Test
    void naoEditaDisciplina() {
        assertThrows(IllegalArgumentException.class, () -> disciplinaValidaTeste.editaDisciplina(disciplina, 2));

        assertThrows(IllegalArgumentException.class, () -> disciplinaValidaTeste.editaDisciplina(null, 1));
    }

    @Test
    void editaDisciplina() {
        assertNotNull(disciplinaValidaTeste.editaDisciplina(disciplinaGetId, 1));
    }
}