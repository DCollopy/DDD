package br.com.gestao_escola.entidade.servico;

import br.com.gestao_escola.entidade.disciplina.Disciplina;

import java.util.List;

public interface DisciplinaService {

        void save(Disciplina disciplina);

        Disciplina findOne(Long id);

        Boolean exist(Long id);

        List<Disciplina> listAll();

        Disciplina edit(Disciplina disciplina, Long id);

}
