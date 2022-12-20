package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.forum.OrganizaForum;
import br.com.gestao_escola.dominio.entidade.servico.ForumService;
import br.com.gestao_escola.dominio.entidade.servico.OrganizaForumService;
import br.com.gestao_escola.web.converte.ForumMapper;
import br.com.gestao_escola.web.converte.OrganizaForumMapper;
import br.com.gestao_escola.web.model.OrganizaForumDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escola/forum")
public class ForumController {
    private final OrganizaForumService organizaForumService;
    private final OrganizaForumMapper organizaForumMapper;
    private final ForumService forumService;
    private final ForumMapper forumMapper;

    public ForumController(OrganizaForumService organizaForumService, OrganizaForumMapper organizaForumMapper
            , ForumService forumService, ForumMapper forumMapper) {
        this.organizaForumMapper = organizaForumMapper;
        this.forumService = forumService;
        this.organizaForumService = organizaForumService;
        this.forumMapper = forumMapper;
    }

    @GetMapping
    public List<OrganizaForum> index() {
        return organizaForumService.listAll();
    }

    @GetMapping({ "/{id}" })
    public OrganizaForum index(@PathVariable int id) {
        return organizaForumService.findOne(id);
    }

    @PostMapping("/criarForum")
    public void criarForum(@RequestBody OrganizaForumDTO organizaForumDTO) {
        organizaForumService.save(organizaForumMapper.converteDTOToOrganizaForum(organizaForumDTO));
        forumService.save(forumMapper.converteDTOToForum(organizaForumDTO.getForum()));
    }
}