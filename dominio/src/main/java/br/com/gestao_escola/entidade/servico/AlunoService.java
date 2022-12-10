package br.com.gestao_escola.entidade.servico;

import br.com.gestao_escola.entidade.aluno.Aluno;

import java.util.List;

public interface AlunoService {

    void save(Aluno aluno);

    Aluno findOne(String cpf);

    Boolean exist(String cpf);

    Aluno edit(Aluno aluno, String cpf);

    void delete(String cpf);

    List<Aluno> listAll();
}
