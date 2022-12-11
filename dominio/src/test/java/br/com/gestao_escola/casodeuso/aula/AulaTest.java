package br.com.gestao_escola.casodeuso.aula;

import br.com.gestao_escola.entidade.aula.Aula;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;

import static br.com.gestao_escola.entidade.objetos.DiaSemana.*;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

class AulaTest {

    protected AulaValidaTest aulaValidaTest = new AulaValidaTest();

    Aula aula = new Aula( "Matematica", "Aula de matematica"
            , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
            , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
            , SEGUNDA, SEXTA, null, TRUE);

    @Test
    void validaAula() {
        assertThrows(IllegalArgumentException.class, () -> aulaValidaTest.validaAula( new Aula( null, "Aula de matematica"
                , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                ,SEGUNDA ,SEXTA, null, TRUE)));

        assertThrows(IllegalArgumentException.class, () -> aulaValidaTest.validaAula( new Aula( "", "Aula de matematica"
                , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                , SEGUNDA, SEXTA, null,TRUE)));

        assertThrows(IllegalArgumentException.class, () -> aulaValidaTest.validaAula( new Aula( "Matematica", null
                , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                , QUINTA, SEXTA, null, TRUE)));


        assertThrows(IllegalArgumentException.class, () -> aulaValidaTest.validaAula( new Aula( "Matematica", ""
                , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                , SEGUNDA, SEXTA, null, TRUE)));


        assertThrows(IllegalArgumentException.class, () -> aulaValidaTest.validaAula( new Aula( "Matematica", "Aula de matematica"
                , null, LocalDate.of(2010, 12, 22)
                , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                , SEGUNDA, SEXTA, null, TRUE)));


        assertThrows(IllegalArgumentException.class, () -> aulaValidaTest.validaAula( new Aula( "Matematica", "Aula de matematica"
                , LocalDate.of(2010, 07, 20), null
                , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                ,SEGUNDA, SEXTA, null, TRUE)));


        assertThrows(IllegalArgumentException.class, () -> aulaValidaTest.validaAula( new Aula( "Matematica", "Aula de matematica"
                , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                , null, LocalTime.of(22, 00, 00)
                , TERCA, SEXTA, null,TRUE)));


        assertThrows(IllegalArgumentException.class, () -> aulaValidaTest.validaAula( new Aula( "Matematica", "Aula de matematica"
                , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                , LocalTime.of(20, 20, 00),null
                , QUARTA, SEXTA, null, TRUE)));


        assertThrows(IllegalArgumentException.class, () -> aulaValidaTest.validaAula( new Aula( "Matematica", "Aula de matematica"
                , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                , null, null, null,TRUE)));

    }

    @Test
    void criaAula() {
        assertNotNull(aula);
    }
}