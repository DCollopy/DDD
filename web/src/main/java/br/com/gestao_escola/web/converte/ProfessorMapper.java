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
        return modelMapper.map(professor, ProfessorDTO.class);
    }

    public Professor converteDTOToProfessor(ProfessorDTO professorDTO) {
        return modelMapper.map(professorDTO, Professor.class);
    }
}