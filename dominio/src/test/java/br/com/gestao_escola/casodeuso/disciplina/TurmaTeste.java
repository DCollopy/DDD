package br.com.gestao_escola.casodeuso.disciplina;

import br.com.gestao_escola.entidade.aluno.Aluno;
import br.com.gestao_escola.entidade.disciplina.Turma;
import br.com.gestao_escola.entidade.objetos.*;
import br.com.gestao_escola.entidade.responsavel.Responsavel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TurmaTeste {

    protected TurmaValidaTeste turmaValida = new TurmaValidaTeste();

    Turma turma = new Turma("Turma1", "Nova turma teste", LocalDate.of(2022, 01, 01), LocalDate.of(2022, 12, 31));

    Responsavel responsavel = new Responsavel("Viviane", "Chaves"
            , new Telefone("22", "12345678")
            , new Endereco("x", "x", "x", "x", "x"
            , new Cep("12345-678"))
            , new Cpf("12345678910")
            , new Email("teste@email.cm"));

    Aluno aluno = new Aluno("Teste1", "Silva"
                    , new Telefone("22", "12345678")
                    , new Endereco("x", "x", "x", "x", "x"
                    , new Cep("12345-678"))
                    , new Cpf("12345678910")
                    , new Email("teste@email.cm"), responsavel);
    Aluno aluno1 = new Aluno("Teste12", "Silva"
            , new Telefone("22", "12345678")
            , new Endereco("x", "x", "x", "x", "x"
            , new Cep("12345-678"))
            , new Cpf("12345678911")
            , new Email("teste@email.cm"), responsavel);


    @Test
    void naoCriaTurma() {
        assertThrows(IllegalArgumentException.class, () -> turmaValida.criaTurma( new Turma("", "Nova turma teste"
                , LocalDate.of(2022, 01, 01)
                , LocalDate.of(2022, 12, 31)), "ADMIN"));

        assertThrows(IllegalArgumentException.class, () -> turmaValida.criaTurma( new Turma(null, "Nova turma teste"
                , LocalDate.of(2022, 01, 01)
                , LocalDate.of(2022, 12, 31)), "ADMIN"));

        assertThrows(IllegalArgumentException.class, () -> turmaValida.criaTurma( new Turma("Turma", "Nova turma teste"
                , null
                , LocalDate.of(2022, 12, 31)), "ADMIN"));

        assertThrows(IllegalArgumentException.class, () -> turmaValida.criaTurma( new Turma("Turma", "Nova turma teste"
                , LocalDate.of(2022, 01, 01)
                , null), "ADMIN"));

        assertThrows(IllegalArgumentException.class, () -> turmaValida.criaTurma( new Turma("Turma", "Nova turma teste"
                , LocalDate.of(2022, 01, 01)
                , LocalDate.of(2022, 12, 31)), ""));

        assertThrows(IllegalArgumentException.class, () -> turmaValida.criaTurma( new Turma("Turma", "Nova turma teste"
                , LocalDate.of(2022, 01, 01)
                , LocalDate.of(2022, 12, 31)), null));
    }

    @Test
    void criaTurma() {
        assertNotNull(turmaValida.criaTurma(turma, "ADMIN"));
    }

    @Test
    void naoEditaTurma(){
        assertThrows(IllegalArgumentException.class, () -> turmaValida.editaTurma(turma, ""));
    }

    @Test
    void editaTurma() {
        turma.setDescricao("Nova descrição");
        assertNotNull(turmaValida.editaTurma(turma, "ADMIN"));
        assertEquals("Nova descrição", turma.getDescricao());
    }

    @Test
    void naoInsereAluno(){
        turma.setAluno(List.of(aluno));
        assertThrows(IllegalArgumentException.class, () ->   turmaValida.insereAlunoTurma(turma, aluno, ""));
    }

    @Test
    void insereAlunoTurma() {
        turmaValida.insereAlunoTurma(turma, aluno, "ADMIN");
        assertEquals(1, turma.getAluno().size());
    }
}