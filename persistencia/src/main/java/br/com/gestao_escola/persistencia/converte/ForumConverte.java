package br.com.gestao_escola.persistencia.converte;

import br.com.gestao_escola.dominio.entidade.forum.Forum;
import br.com.gestao_escola.persistencia.entidade.ForumEntidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ForumConverte {

    private final ModelMapper modelMapper;

    public Forum converteEntidadeToForum(ForumEntidade forumEntidade) {
        return modelMapper.map(forumEntidade, Forum.class);
    }

    public ForumEntidade converteForumToEntidade(Forum forum) {
        return modelMapper.map(forum, ForumEntidade.class);
    }
}