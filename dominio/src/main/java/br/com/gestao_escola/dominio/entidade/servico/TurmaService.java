package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.disciplina.Turma;

import java.util.List;

public interface TurmaService {

    void save(Turma turma, String identidade);

    Turma edit(Turma turma, String identidade);

    List<Turma> findAll();

    Turma findById(float id);

    Boolean existsById(float id);

    void delete(Turma turma);
}