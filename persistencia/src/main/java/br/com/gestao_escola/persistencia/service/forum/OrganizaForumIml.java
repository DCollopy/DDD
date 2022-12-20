package br.com.gestao_escola.persistencia.service.forum;

import br.com.gestao_escola.dominio.entidade.forum.OrganizaForum;
import br.com.gestao_escola.dominio.entidade.servico.OrganizaForumService;
import br.com.gestao_escola.persistencia.converte.OrganizaForumConverte;
import br.com.gestao_escola.persistencia.repositorio.OrganizaForumRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizaForumIml implements OrganizaForumService {
    private final OrganizaForumConverte organizaForumConverte;
    private final OrganizaForumRepositorio organizaForumRepositorio;
    private OrganizaForumAbs organizaForumAbs = new OrganizaForumAbs();

    public OrganizaForumIml(OrganizaForumConverte organizaForumConverte, OrganizaForumRepositorio organizaForumRepositorio) {
        this.organizaForumConverte = organizaForumConverte;
        this.organizaForumRepositorio = organizaForumRepositorio;
    }

    @Override
    public void save(OrganizaForum organizaForum) {
        organizaForumAbs.criaOrganizaForum(organizaForum);
        organizaForumRepositorio.save(organizaForumConverte.converteOrganizaForumToEntidade(organizaForum));
    }

    @Override
    public OrganizaForum findOne(int id) {
        return organizaForumConverte.converteEntidadeToOrganizaForum(organizaForumRepositorio.getOne(id));
    }

    @Override
    public Boolean exist(int id) {
        return organizaForumRepositorio.existsById(id);
    }

    @Override
    public List<OrganizaForum> listAll() {
        return organizaForumRepositorio.findAll().stream()
                .map(organizaForumConverte::converteEntidadeToOrganizaForum).collect(Collectors.toList());
    }
}