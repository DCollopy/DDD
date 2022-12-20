package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.forum.OrganizaForum;

import java.util.List;

public interface OrganizaForumService {
    void save(OrganizaForum organizaForum);

    OrganizaForum findOne(int id);

    Boolean exist(int id);

    List<OrganizaForum> listAll();
}