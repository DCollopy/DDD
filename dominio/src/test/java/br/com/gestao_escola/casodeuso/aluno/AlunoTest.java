package br.com.gestao_escola.casodeuso.aluno;

import br.com.gestao_escola.entidade.aluno.Aluno;
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
    void criaAluno() {
        assertNotNull(alunoValidaTest.criaAluno(aluno));
    }
}