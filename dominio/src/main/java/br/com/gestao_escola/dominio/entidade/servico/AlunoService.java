package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.dominio.entidade.objetos.Cpf;

import java.util.List;

public interface AlunoService {

    void save(Aluno aluno);

    Aluno findOne(Cpf cpf);

    Boolean exist(Aluno aluno);

    void edit(Aluno aluno);

    List<Aluno> listAll();

    void delete(Cpf cpf);
}
