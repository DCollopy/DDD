package br.com.gestao_escola.persistencia.casodeuso.aluno;

import br.com.gestao_escola.dominio.casodeuso.aluno.FaltaValidaTeste;
import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.dominio.entidade.aluno.Falta;
import br.com.gestao_escola.dominio.entidade.aula.Aula;
import br.com.gestao_escola.dominio.entidade.objetos.*;
import br.com.gestao_escola.dominio.entidade.responsavel.Responsavel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static br.com.gestao_escola.dominio.entidade.objetos.DiaSemana.SEGUNDA;
import static br.com.gestao_escola.dominio.entidade.objetos.DiaSemana.SEXTA;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

class FaltaTeste {

    protected FaltaValidaTeste faltaValida = new FaltaValidaTeste();

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
    Aula aula = new Aula( "Matematica", "Aula de matematica"
            , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
            , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
            , SEGUNDA, SEXTA, null, TRUE);

    Falta falta = new Falta(aluno, aula, "");
    Falta presenca = new Falta(aluno, aula);

    List<Falta> faltaList = List.of(falta
            ,presenca
            , new Falta(new Aluno("Pedro", "Silva"
                    , new Telefone("22", "12345678")
                    , new Endereco("x", "x", "x", "x", "x"
                    , new Cep("12345-678"))
                    , new Cpf("12345678922")
                    , new Email("teste@email.cm")
                    ,responsavel)
                    , new Aula( "Matematica", "Aula de matematica"
                    , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                    , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                    , SEGUNDA, SEXTA, null, TRUE), "")
            , new Falta(new Aluno("Pedro", "Silva"
                    , new Telefone("22", "12345678")
                    , new Endereco("x", "x", "x", "x", "x"
                    , new Cep("12345-678"))
                    , new Cpf("12345678920")
                    , new Email("teste@email.cm")
                    ,responsavel)
                    , new Aula( "Matematica", "Aula de matematica"
                    , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                    , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                    , SEGUNDA, SEXTA, null, TRUE))
            , new Falta(new Aluno("Pedro", "Silva"
                    , new Telefone("22", "12345678")
                    , new Endereco("x", "x", "x", "x", "x"
                    , new Cep("12345-678"))
                    , new Cpf("12345678935")
                    , new Email("teste@email.cm")
                    ,responsavel)
                    , new Aula( "Matematica", "Aula de matematica"
                    , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                    , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                    , SEGUNDA, SEXTA, null, FALSE), ""));

    List<Falta> faltaListCalculo = List.of(falta
            ,presenca
            , new Falta(new Aluno("Pedro", "Silva"
                    , new Telefone("22", "12345678")
                    , new Endereco("x", "x", "x", "x", "x"
                    , new Cep("12345-678"))
                    , new Cpf("12345678910")
                    , new Email("teste@email.cm")
                    , responsavel)
                    , new Aula( "Matematica", "Aula de matematica"
                    , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                    , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                    , SEGUNDA, SEXTA, null, TRUE))
            , new Falta(new Aluno("Pedro", "Silva"
                    , new Telefone("22", "12345678")
                    , new Endereco("x", "x", "x", "x", "x"
                    , new Cep("12345-678"))
                    , new Cpf("12345678910")
                    , new Email("teste@email.cm")
                    , responsavel)
                    , new Aula( "Matematica", "Aula de matematica"
                    , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                    , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                    , SEGUNDA, SEXTA, null, TRUE))
            , new Falta(new Aluno("Pedro", "Silva"
                    , new Telefone("22", "12345678")
                    , new Endereco("x", "x", "x", "x", "x"
                    , new Cep("12345-678"))
                    , new Cpf("12345678910")
                    , new Email("teste@email.cm")
                    , responsavel)
                    , new Aula( "Matematica", "Aula de matematica"
                    , LocalDate.of(2010, 07, 20), LocalDate.of(2010, 12, 22)
                    , LocalTime.of(20, 20, 00), LocalTime.of(22, 00, 00)
                    , SEGUNDA, SEXTA, null, TRUE)));

    @Test
    void criaFalta() {
        String professor = "PROFESSOR";
        assertNotNull(faltaValida.criaFalta(falta, professor));

        assertNotNull(faltaValida.criaFalta(presenca, professor));
    }

    @Test
    void criaPresenca() {
        String professor = "PROFESSOR";
        assertNotNull(faltaValida.criaPresenca(presenca, professor));
    }

    @Test
    void editFalta() {
        LocalDate date = LocalDate.of(2010, 07, 20);
        faltaList.stream().filter(falta -> falta.getAluno().getCpf().getNumero().equals("12345678910") && falta.getNumeroFaltas() == 1)
                .forEach(falta -> falta.setFalta_data(date));

        faltaValida.editFalta(faltaList, "PROFESSOR", "12345678910", date);
    }

    @Test
    void naoCalculaFatal() {
        String professor = "PROFESSOR";
        assertThrows(IllegalArgumentException.class, () -> faltaValida.calculaFalta(faltaListCalculo, "ADMIN", "12345678910"));

        assertThrows(IllegalArgumentException.class, () -> faltaValida.calculaFalta(faltaListCalculo, professor, "12345678944"));

        faltaListCalculo.stream().filter(falta -> falta.getAluno().getCpf().getNumero().equals("12345678910"))
                .forEach(falta -> falta.getAula().setAulaAtiva(FALSE));

        assertThrows(IllegalArgumentException.class, () -> faltaValida.calculaFalta(faltaListCalculo, professor, "12345678910"));
    }
    @Test
    void calculaFalta() {
        assertNotNull(faltaValida.calculaFalta(faltaListCalculo,  "PROFESSOR", "12345678910"));
    }

    @Test
    void alunoReprovaFalta() {
        faltaValida.calculaFalta(faltaListCalculo,  "PROFESSOR", "12345678910");
        assertTrue(faltaValida.alunoReprovaFalta(faltaListCalculo.stream().iterator().next(),  "12345678910"));

    }

}