package br.com.gestao_escola.casodeuso.forum;

import br.com.gestao_escola.entidade.forum.Forum;


public abstract class ForumValida<T> {


    public Forum criaForum( Forum forum) {
          try {
                return new Forum(forum.getMensagem(), forum.getIdentidade());
            } catch (Exception e) {
                throw new IllegalArgumentException("Ops, algo deu errado");
            }
    }

}
