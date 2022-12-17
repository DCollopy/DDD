package br.com.gestao_escola.web.converte;

import br.com.gestao_escola.dominio.entidade.responsavel.Responsavel;
import br.com.gestao_escola.web.model.ResponsavelDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResponsavelMapper {
    private final ModelMapper modelMapper;
    public Responsavel converteDTOToResponsavel(ResponsavelDTO responsavelDTO) {
        //modelMapper.createTypeMap(ResponsavelDTO.class, Pessoa.class)
                //.setConverter(Responsavel:: new);
//        TypeMap<Pessoa, PessoaDTO> typeMap = modelMapper.createTypeMap(Pessoa.class, PessoaDTO.class)
//                .addMapping(Pessoa::getNome, PessoaDTO::setNome)
//                .addMapping(Pessoa::getSobrenome, PessoaDTO::setSobrenome)
//                .addMapping(Pessoa::getCpf, PessoaDTO::setCpf)
//                .addMapping(Pessoa::getEmail, PessoaDTO::setEmail)
//                .addMapping(Pessoa::getTelefone, PessoaDTO::setTelefone)
//                .addMapping(Pessoa::getEndereco, PessoaDTO::setEndereco);
        TypeMap<Responsavel, ResponsavelDTO> typeMap = modelMapper.createTypeMap(Responsavel.class, ResponsavelDTO.class)
                .addMapping(Responsavel::getNome, ResponsavelDTO::setNome)
                .addMapping(Responsavel::getSobrenome, ResponsavelDTO::setSobrenome)
                .addMapping(Responsavel::getCpf, ResponsavelDTO::setCpf)
                .addMapping(Responsavel::getEmail, ResponsavelDTO::setEmail)
                .addMapping(Responsavel::getTelefone, ResponsavelDTO::setTelefone)
                .addMapping(Responsavel::getEndereco, ResponsavelDTO::setEndereco);
        //typeMap.include(Responsavel.class, ResponsavelDTO.class);
        //TypeMap<Responsavel, ResponsavelDTO> typeMap = modelMapper.createTypeMap(Responsavel.class, ResponsavelDTO.class);
        //typeMap.includeBase(baseTypeMap);

        return modelMapper.map(responsavelDTO, Responsavel.class);
    }

    public ResponsavelDTO converteResponsavelToDTO(Responsavel responsavel) {
        return modelMapper.map(responsavel, ResponsavelDTO.class);
    }

}
