package br.com.gestao_escola.web.converte;

import br.com.gestao_escola.dominio.entidade.forum.OrganizaForum;
import br.com.gestao_escola.web.model.OrganizaForumDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrganizaForumMapper {

    private final ModelMapper modelMapper;

    public OrganizaForum converteDTOToOrganizaForum(OrganizaForumDTO organizaForumDTO) {
        return modelMapper.map(organizaForumDTO, OrganizaForum.class);
    }

    public OrganizaForumDTO converteOrganizaForumToDTO(OrganizaForum organizaForum) {
        return modelMapper.map(organizaForum, OrganizaForumDTO.class);
    }
}
