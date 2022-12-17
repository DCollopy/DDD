package br.com.gestao_escola.web.converte;

import br.com.gestao_escola.dominio.entidade.objetos.Cpf;
import br.com.gestao_escola.web.model.CpfDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CpfMapper {

    private final ModelMapper modelMapper;

    public Cpf converteDTOToCpf(CpfDTO cpfDTO) {
        return modelMapper.map(cpfDTO, Cpf.class);
    }

    public CpfDTO converteCpfToDTO(Cpf cpf) {
        return modelMapper.map(cpf, CpfDTO.class);
    }
}
