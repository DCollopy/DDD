package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.objetos.Cpf;
import br.com.gestao_escola.dominio.entidade.professor.Professor;

import java.util.List;

public interface ProfessorService {

    void save(Professor professor);

    Professor findOne(Cpf cpf);

    Boolean exist(Cpf cpf);

    Professor edit(Professor professor);

    void delete(Cpf cpf);

    List<Professor> listAll();
}
