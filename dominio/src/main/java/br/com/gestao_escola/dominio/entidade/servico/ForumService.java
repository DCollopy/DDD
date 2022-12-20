package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.forum.Forum;

import java.util.List;

public interface ForumService {
    void save(Forum forum);
    Forum findOne(int id);
    Boolean exist(int id);
    List<Forum> listAll();
    Forum edit(Forum forum);
}