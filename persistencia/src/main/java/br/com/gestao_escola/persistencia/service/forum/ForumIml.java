package br.com.gestao_escola.persistencia.service.forum;

import br.com.gestao_escola.dominio.entidade.forum.Forum;
import br.com.gestao_escola.dominio.entidade.servico.ForumService;
import br.com.gestao_escola.persistencia.converte.ForumConverte;
import br.com.gestao_escola.persistencia.repositorio.ForumRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumIml implements ForumService {

    private final ForumRepositorio forumRepositorio;

    private final ForumConverte forumConverte;

    private ForumValidaAbs forumValidaAbs = new ForumValidaAbs();

    public ForumIml(ForumRepositorio forumRepositorio, ForumConverte forumConverte) {
        this.forumRepositorio = forumRepositorio;
        this.forumConverte = forumConverte;
    }

    @Override
    public void save(Forum forum) {
        forumValidaAbs.criaForum(forum);
        forumRepositorio.save(forumConverte.converteForumToEntidade(forum));
    }

    @Override
    public Forum findOne(int id) {
        return forumConverte.converteEntidadeToForum(forumRepositorio.findById(id).get());
    }

    @Override
    public Boolean exist(int id) {
        return forumRepositorio.existsById(id);
    }

    @Override
    public List<Forum> listAll() {
        return forumRepositorio.findAll().stream().map(forumConverte::converteEntidadeToForum).collect(Collectors.toList());
    }

    @Override
    public Forum edit(Forum forum) {
        return forumConverte.converteEntidadeToForum(forumRepositorio.save(forumConverte.converteForumToEntidade(forum)));
    }
}