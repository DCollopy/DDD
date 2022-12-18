package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.forum.OrganizaForum;

import java.util.List;

public interface OrganizaForumService {
    void save(OrganizaForum organizaForum);

    OrganizaForum findOne(float id);

    Boolean exist(float id);

    List<OrganizaForum> listAll();
}