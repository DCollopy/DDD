package br.com.gestao_escola.entidade.servico;

import br.com.gestao_escola.entidade.forum.OrganizaForum;

public interface OrganizaForumService {

    void save(OrganizaForum organizaForum);

    OrganizaForum findOne(float id);

    Boolean exist(float id);

    void delete(float id);

    OrganizaForum edit(OrganizaForum organizaForum, float id);


}
