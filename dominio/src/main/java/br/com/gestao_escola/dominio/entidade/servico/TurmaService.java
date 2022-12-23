package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.disciplina.Turma;

import java.util.List;

public interface TurmaService {

    void save(Turma turma, String identidade);

    Turma edit(int id, String identidade, Turma turmaEditada);

    List<Turma> findAll();

    Turma findById(int id);

    Boolean existsById(int id);

    void delete(Turma turma);
}