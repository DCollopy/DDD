package br.com.gestao_escola.web.converte;

import br.com.gestao_escola.dominio.entidade.forum.Forum;
import br.com.gestao_escola.web.model.ForumDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ForumMapper {
    private final ModelMapper modelMapper;

    public Forum converteDTOToForum(ForumDTO forumDTO) {
        return modelMapper.map(forumDTO, Forum.class);
    }

    public ForumDTO converteForumToDTO(Forum forum) {
        return modelMapper.map(forum, ForumDTO.class);
    }
}