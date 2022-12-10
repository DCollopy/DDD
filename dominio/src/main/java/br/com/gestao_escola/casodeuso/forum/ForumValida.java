package br.com.gestao_escola.casodeuso.forum;

import br.com.gestao_escola.entidade.forum.Forum;


public abstract class ForumValida {

     public void valida(Forum forum, long id){
        if(forum.getMensagem() == null || forum.getMensagem().isEmpty()) {
            throw new IllegalArgumentException("Mensagem não pode ser nula ou vazia");
        }
        if(forum.getIdentidade() == null || forum.getIdentidade().isEmpty()) {
            throw new IllegalArgumentException("Ops, por aqui só pode postar quem está logado");
        }
        if(id == 0) {
            throw new IllegalArgumentException("Ops, Algo deu muito errado !");
        }
    }

    public Forum criaForum(long id, Forum forum) {
        valida(forum, id);
        return new Forum(forum.getMensagem(), forum.getIdentidade());
    }

}
