package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.disciplina.Disciplina;

import java.util.List;

public interface DisciplinaService {
    void save(Disciplina disciplina);
    Disciplina findOne(int id);
    Boolean exist(int id);
    List<Disciplina> listAll();
    Disciplina edit(Disciplina disciplina);
    void delete(int id);
}