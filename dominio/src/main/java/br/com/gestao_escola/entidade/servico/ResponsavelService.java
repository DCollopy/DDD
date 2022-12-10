package br.com.gestao_escola.entidade.servico;

import br.com.gestao_escola.entidade.objetos.Cpf;
import br.com.gestao_escola.entidade.responsavel.Responsavel;

import java.util.List;

public interface ResponsavelService {

    void save(Responsavel responsavel);

    Responsavel findOne(Cpf cpf);

    Boolean exist(Cpf cpf);

    List<Responsavel> listAll();

    Responsavel edit(Responsavel responsavel, Cpf cpf);


}
