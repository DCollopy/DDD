package br.com.gestao_escola.casodeuso.aluno;

import br.com.gestao_escola.entidade.aluno.Aluno;
import br.com.gestao_escola.entidade.disciplina.Disciplina;
import br.com.gestao_escola.entidade.objetos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    protected AlunoValidaTest alunoValidaTest = new AlunoValidaTest();

    Aluno aluno = new Aluno("Pedro", "Silva"
            , new Telefone("22", "12345678")
            , new Endereco("x", "x", "x", "x", "x"
            , new Cep("12345-678"))
            , new Cpf("12345678910")
            , new Email("teste@email.cm"));

    @Test
    void valida() {
        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno(null, "Silva"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", null
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", ""
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", "Silva"
                , new Telefone("22", null)
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", "Silva"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep(null))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", "Silva"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf(null)
                , new Email("teste@email.cm")));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", "Silva"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email(null)));
    }
    @Test
    void criaAluno() {
        assertNotNull(alunoValidaTest.criaAluno(aluno));
    }

    @Test
    void naoEditaAluno() {
        assertThrows(IllegalArgumentException.class, () -> alunoValidaTest.editAluno(aluno, null));

        assertThrows(IllegalArgumentException.class, () -> alunoValidaTest.editAluno(null, new Cpf("12345678910")));

        assertThrows(IllegalArgumentException.class, () -> alunoValidaTest.editAluno(aluno, new Cpf("")));

        assertThrows(IllegalArgumentException.class, () -> alunoValidaTest.editAluno(aluno, new Cpf("12345678922")));
    }
    @Test
    void editAluno() {
        Cpf cpf = new Cpf("12345678910");
        assertNotNull(alunoValidaTest.editAluno(aluno, cpf));
    }
}