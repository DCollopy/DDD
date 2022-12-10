package br.com.gestao_escola.entidade.servico;

import br.com.gestao_escola.entidade.aluno.Falta;

public interface FaltaService {

    void save(Falta falta);

    Falta findOne(Long id);

    void delete(Long id);
}
