package br.com.gestao_escola.web.converte;

import br.com.gestao_escola.dominio.entidade.admin.Admin;
import br.com.gestao_escola.web.model.AdminDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminMapper {
    private final ModelMapper modelMapper;

    public Admin converteDTOToAdmin(AdminDTO adminDTO) {
        return modelMapper.map(adminDTO, Admin.class);
    }

    public AdminDTO converteAdminToDTO(Admin admin) {
        return modelMapper.map(admin, AdminDTO.class);
    }
}