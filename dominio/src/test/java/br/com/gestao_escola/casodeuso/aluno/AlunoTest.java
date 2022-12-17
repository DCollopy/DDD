package br.com.gestao_escola.casodeuso.aluno;

import br.com.gestao_escola.dominio.casodeuso.aluno.AlunoValidaTest;
import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.dominio.entidade.objetos.*;
import br.com.gestao_escola.dominio.entidade.responsavel.Responsavel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    protected AlunoValidaTest alunoValidaTest = new AlunoValidaTest();
    Responsavel responsavel = new Responsavel("Viviane", "Chaves"
            , new Telefone("22", "12345678")
            , new Endereco("x", "x", "x", "x", "x"
            , new Cep("12345-678"))
            , new Cpf("12345678910")
            , new Email("teste@email.cm"));
    Aluno aluno = new Aluno("Pedro", "Silva"
            , new Telefone("22", "12345678")
            , new Endereco("x", "x", "x", "x", "x"
            , new Cep("12345-678"))
            , new Cpf("12345678910")
            , new Email("teste@email.cm")
            , responsavel);

    @Test
    void valida() {
        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno(null, "Silva"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")
                , responsavel));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", null
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")
                , responsavel));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", ""
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")
                , responsavel));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", "Silva"
                , new Telefone("22", null)
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")
                , responsavel));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", "Silva"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep(null))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")
                , responsavel));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", "Silva"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf(null)
                , new Email("teste@email.cm")
                , responsavel));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", "Silva"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email(null)
                , responsavel));

        assertThrows(IllegalArgumentException.class, () ->  aluno = new Aluno("Pedro", "Silva"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf(null)
                , new Email("teste@email.cm")
                , null));
        }
    @Test
    void criaAluno() {
        assertNotNull(alunoValidaTest.criaAluno(aluno));
    }

    @Test
    void naoEditaAluno() {
        assertThrows(IllegalArgumentException.class, () -> alunoValidaTest.editAluno(null));
    }
    @Test
    void editAluno() {
        Cpf cpf = new Cpf("12345678910");
        assertNotNull(alunoValidaTest.editAluno(aluno));
    }
}