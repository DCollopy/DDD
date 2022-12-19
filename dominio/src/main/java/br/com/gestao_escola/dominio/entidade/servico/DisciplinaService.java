package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.disciplina.Disciplina;

import java.util.List;

public interface DisciplinaService {
    void save(Disciplina disciplina);
    Disciplina findOne(float id);
    Boolean exist(float id);
    List<Disciplina> listAll();
    Disciplina edit(Disciplina disciplina);
    void delete(float id);
}