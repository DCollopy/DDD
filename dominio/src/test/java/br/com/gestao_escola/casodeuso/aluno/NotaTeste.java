package br.com.gestao_escola.casodeuso.aluno;

import br.com.gestao_escola.entidade.aluno.Aluno;
import br.com.gestao_escola.entidade.aluno.Nota;
import br.com.gestao_escola.entidade.aula.Aula;
import br.com.gestao_escola.entidade.objetos.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static br.com.gestao_escola.entidade.objetos.DiaSemana.SEGUNDA;
import static br.com.gestao_escola.entidade.objetos.DiaSemana.SEXTA;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

class NotaTeste {

    protected NotaValidaTeste notaValidaTeste = new NotaValidaTeste();

    Aluno aluno = new Aluno("Pedro", "Silva"
            , new Telefone("22", "12345678")
            , new Endereco("x", "x", "x", "x", "x"
            , new Cep("12345-678"))
            , new Cpf("12345678910")
            , new Email("teste@email.cm"));

    Aula aula = new Aula( "Matematica", "Aula de matematica"
            , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
            , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
            , SEGUNDA, SEXTA, null, TRUE);

    Nota nota = new Nota(10.0, aula, aluno);

    List<Nota> notaList = List.of(nota
            , new Nota(9.0, aula, aluno)
            , new Nota(8.0, aula, aluno)
            , new Nota(8.0, aula, aluno));

    @Test
    void criaNota() {
        assertNotNull(notaValidaTeste.criaNota(nota));
    }

    @Test
    void mediaNota() {
        assertNotNull(notaValidaTeste.mediaNota(notaList, aluno.getCpf().getNumero(), nota.getId(), "PROFESSOR"));
    }
}