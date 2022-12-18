package br.com.gestao_escola.persistencia.converte;

import br.com.gestao_escola.dominio.entidade.forum.OrganizaForum;
import br.com.gestao_escola.persistencia.entidade.OrganizaForumEntidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrganizaForumConverte {

    private final ModelMapper modelMapper;

    public OrganizaForum converteEntidadeToOrganizaForum(OrganizaForumEntidade organizaForumEntidade) {
        return modelMapper.map(organizaForumEntidade, OrganizaForum.class);
    }

    public OrganizaForumEntidade converteOrganizaForumToEntidade(OrganizaForum organizaForum) {
        return modelMapper.map(organizaForum, OrganizaForumEntidade.class);
    }
}