package br.com.gestao_escola.dominio.casodeuso.forum;

import br.com.gestao_escola.dominio.entidade.forum.Forum;

import java.util.logging.Logger;

public abstract class ForumValida<T> {
    public Forum criaForum(Forum forum) {
        try {
            return new Forum(forum.getMensagem(), forum.getIdentidade());
        } catch (Exception e) {
            Logger.getLogger("Forum").info("Forum nao criada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }
}