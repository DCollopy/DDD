package br.com.gestao_escola.casodeuso.forum;

import br.com.gestao_escola.entidade.aluno.Aluno;
import br.com.gestao_escola.entidade.forum.Forum;
import br.com.gestao_escola.entidade.objetos.*;
import br.com.gestao_escola.entidade.professor.Professor;
import br.com.gestao_escola.entidade.responsavel.Responsavel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ForumTest {

    protected ForumValidaTest forumTest = new ForumValidaTest();

    Professor professor = new Professor("Joao", "Silva",
            new Cpf("12345678910"));
    Responsavel responsavel = new Responsavel("Joao", "Silva"
            , new Telefone("22", "12345678")
            , new Endereco("x", "x", "x", "x", "x"
            , new Cep("12345-678"))
            , new Cpf("12345678910")
            , new Email("vanessa@email.com"));
    Aluno aluno = new Aluno("Joao", "Silva",
            new Cpf("12345678910"),responsavel);

    @Test
    void naoCriaForm() {
        assertThrows(IllegalArgumentException.class, () -> forumTest.criaForum(new Forum("Mensagem", null)));

        assertThrows(IllegalArgumentException.class, () -> forumTest.criaForum(new Forum("", professor)));

        assertThrows(IllegalArgumentException.class, () -> forumTest.criaForum(new Forum(null, aluno)));


    }

    @Test
    void criaForum() {
        assertNotNull(forumTest.criaForum(new Forum("Mensagem", professor)));

        assertNotNull(forumTest.criaForum(new Forum("Mensagem", aluno)));

        assertNotNull(forumTest.criaForum(new Forum("Mensagem", responsavel)));
    }
}