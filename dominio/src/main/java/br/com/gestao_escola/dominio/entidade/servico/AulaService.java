package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.aula.Aula;

import java.util.List;

public interface AulaService {

    void save(Aula aula);

    Aula findOne(float id);

    List<Aula> listAll();


}
