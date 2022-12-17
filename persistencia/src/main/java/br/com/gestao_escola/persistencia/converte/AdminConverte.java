package br.com.gestao_escola.persistencia.converte;

import br.com.gestao_escola.dominio.entidade.admin.Admin;
import br.com.gestao_escola.persistencia.entidade.AdminEntidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminConverte {

    private final ModelMapper modelMapper;

    public Admin converteEntitidadeToAdmin(AdminEntidade adminEntidade) {
        return modelMapper.map(adminEntidade, Admin.class);
    }

    public AdminEntidade converteAdminToEntidade(Admin admin) {
        return modelMapper.map(admin, AdminEntidade.class);
    }
}