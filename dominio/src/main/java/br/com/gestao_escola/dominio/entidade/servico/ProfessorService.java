package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.objetos.Cpf;
import br.com.gestao_escola.dominio.entidade.professor.Professor;

import java.util.List;

public interface ProfessorService {

    void save(Professor professor);

    Professor findOne(String cpf);

    Boolean exist(String cpf);

    Professor edit(Professor professor);

    void delete(String cpf);

    List<Professor> listAll();
}
