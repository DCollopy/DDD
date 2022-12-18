package br.com.gestao_escola.dominio.casodeuso.forum;

import br.com.gestao_escola.dominio.entidade.forum.OrganizaForum;

public abstract class OrganizaForumValida {

    public OrganizaForum criaOrganizaForum(OrganizaForum organizaForum) {
        return new OrganizaForum(organizaForum.getTitulo(), organizaForum.getForum());
    }
}