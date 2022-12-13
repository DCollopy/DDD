package br.com.gestao_escola.persistencia.casodeuso.responsavel;

import br.com.gestao_escola.dominio.casodeuso.responsavel.ResponsavelValidaTest;
import br.com.gestao_escola.dominio.entidade.objetos.*;
import br.com.gestao_escola.dominio.entidade.responsavel.Responsavel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResponsavelTest {

    protected ResponsavelValidaTest responsavelValidaTest = new ResponsavelValidaTest();

    Responsavel responsavel = new Responsavel("Viviane", "Chaves"
            , new Telefone("22", "12345678")
            , new Endereco("x", "x", "x", "x", "x"
            , new Cep("12345-678"))
            , new Cpf("12345678910")
            , new Email("teste@email.cm"));

    @Test
    void valida() {
        assertThrows(IllegalArgumentException.class, () -> responsavel = new Responsavel("Viviane", "Chaves"
                , new Telefone("22", "")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")));

        assertThrows(IllegalArgumentException.class, () -> responsavel = new Responsavel("Viviane", "Chaves"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep(null))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")));

        assertThrows(IllegalArgumentException.class, () -> responsavel = new Responsavel("Viviane", "Chaves"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep(""))
                , new Cpf("12345678910")
                , new Email("teste@email.cm")));

        assertThrows(IllegalArgumentException.class, () -> responsavel = new Responsavel("Viviane", "Chaves"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("")
                , new Email("teste@email.cm")));

        assertThrows(IllegalArgumentException.class, () -> responsavel = new Responsavel("Viviane", "Chaves"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf(null)
                , new Email("teste@email.cm")));

        assertThrows(IllegalArgumentException.class, () -> responsavel = new Responsavel("Viviane", "Chaves"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email(null)));

        assertThrows(IllegalArgumentException.class, () -> responsavel = new Responsavel("Viviane", "Chaves"
                , new Telefone("22", "12345678")
                , new Endereco("x", "x", "x", "x", "x"
                , new Cep("12345-678"))
                , new Cpf("12345678910")
                , new Email("")));

    }

    @Test
    void criaResponsavel() {
        assertNotNull(responsavelValidaTest.criaResponsavel(responsavel));
    }
}