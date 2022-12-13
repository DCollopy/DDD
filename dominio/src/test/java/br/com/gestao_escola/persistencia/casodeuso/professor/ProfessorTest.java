package br.com.gestao_escola.persistencia.casodeuso.professor;

import br.com.gestao_escola.dominio.casodeuso.professor.ProfessorValidaTest;
import br.com.gestao_escola.dominio.entidade.objetos.*;
import br.com.gestao_escola.dominio.entidade.professor.Professor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProfessorTest {

    protected ProfessorValidaTest professorValidaTest = new ProfessorValidaTest();

    Professor professor = new Professor("Joao", "Silva"
            , new Telefone("22", "12345678")
            , new Endereco("x", "x", "x", "x", "x"
            , new Cep("12345-678"))
            , new Cpf("12345678910")
            , new Email("teste@email.cm"));

    @Test
    void naoCriaProfessor() {
        assertThrows(IllegalArgumentException.class, () -> professorValidaTest.criaProfessor(new Professor("", "Silva", new Cpf("12345678910"))));

        assertThrows(IllegalArgumentException.class, () -> professorValidaTest.criaProfessor(new Professor(null, "Silva", new Cpf("12345678910"))));

        assertThrows(IllegalArgumentException.class, () -> professorValidaTest.criaProfessor(new Professor("Joao", "", new Cpf("12345678910"))));

        assertThrows(IllegalArgumentException.class, () -> professorValidaTest.criaProfessor(new Professor("Joao", null, new Cpf("12345678910"))));

        assertThrows(IllegalArgumentException.class, () -> professorValidaTest.criaProfessor(new Professor("Joao", "Silva"
                , new Telefone("", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email("teste@email.cm"))));

        assertThrows(IllegalArgumentException.class, () -> professorValidaTest.criaProfessor(new Professor("Joao", "Silva"
                , new Telefone("22", "12345678")
                , new Endereco(null, null, null, "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email("teste@email.cm"))));

        assertThrows(IllegalArgumentException.class, () -> professorValidaTest.criaProfessor(new Professor("Joao", "Silva"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                ,new Email(null))));
    }

    @Test
    void criaProfessor() {
        assertNotNull(professorValidaTest.criaProfessor(professor));
    }

}