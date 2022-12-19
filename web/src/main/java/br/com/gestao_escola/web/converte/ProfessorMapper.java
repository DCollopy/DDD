package br.com.gestao_escola.web.converte;

import br.com.gestao_escola.dominio.entidade.professor.Professor;
import br.com.gestao_escola.web.model.ProfessorDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfessorMapper {
    private final ModelMapper modelMapper;

    public ProfessorDTO converteProfessorToDTO(Professor professor) {
        modelMapper.createTypeMap(Professor.class, ProfessorDTO.class)
                .addMapping(Professor::getNome, ProfessorDTO::setNome)
                .addMapping(Professor::getSobrenome, ProfessorDTO::setSobrenome)
                .addMapping(Professor::getCpf, ProfessorDTO::setCpf)
                .addMapping(Professor::getEmail, ProfessorDTO::setEmail)
                .addMapping(Professor::getTelefone, ProfessorDTO::setTelefone)
                .addMapping(Professor::getEndereco, ProfessorDTO::setEndereco);

        return modelMapper.map(professor, ProfessorDTO.class);
    }

    public Professor converteDTOToProfessor(ProfessorDTO professorDTO) {
        modelMapper.createTypeMap(ProfessorDTO.class, Professor.class)
                .addMapping(ProfessorDTO::getNome, Professor::setNome)
                .addMapping(ProfessorDTO::getSobrenome, Professor::setSobrenome)
                .addMapping(ProfessorDTO::getCpf, Professor::setCpf)
                .addMapping(ProfessorDTO::getEmail, Professor::setEmail)
                .addMapping(ProfessorDTO::getTelefone, Professor::setTelefone)
                .addMapping(ProfessorDTO::getEndereco, Professor::setEndereco);
        return modelMapper.map(professorDTO, Professor.class);
    }
}