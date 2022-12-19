package br.com.gestao_escola.web.converte;

import br.com.gestao_escola.dominio.entidade.disciplina.Disciplina;
import br.com.gestao_escola.web.model.DisciplinaDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DisciplinaMapper {

    private final ModelMapper modelMapper;

    public Disciplina converteDTOToDisciplina(DisciplinaDTO disciplinaDTO) {
        return modelMapper.map(disciplinaDTO, Disciplina.class);
    }

    public DisciplinaDTO converteDisciplinaToDTO(Disciplina disciplina) {
        return modelMapper.map(disciplina, DisciplinaDTO.class);
    }
}