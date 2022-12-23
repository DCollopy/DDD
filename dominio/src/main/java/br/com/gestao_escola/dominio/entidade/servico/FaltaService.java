package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.dominio.entidade.aluno.Falta;
import java.time.LocalDate;
import java.util.List;

public interface FaltaService {
    void criaFalta(Falta falta, String professor);
    void criaPresenca(Falta falta, String professor);
    Falta findOne(int id);
    boolean alunoReprovaFalta(Aluno aluno);
    List<Falta> calculaFalta(String professor, String cpf);
    void editaFalta(String professor, String cpf, LocalDate acheData);
    List<Falta> findAll();
}