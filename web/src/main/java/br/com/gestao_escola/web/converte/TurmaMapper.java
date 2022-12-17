package br.com.gestao_escola.web.converte;

import br.com.gestao_escola.dominio.entidade.disciplina.Turma;
import br.com.gestao_escola.web.model.TurmaDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TurmaMapper {

    private final ModelMapper modelMapper;

    public Turma converteDTOToTurma(TurmaDTO turmaDTO) {
        return modelMapper.map(turmaDTO, Turma.class);
    }

    public TurmaDTO converteTurmaToDTO(Turma turma) {
        return modelMapper.map(turma, TurmaDTO.class);
    }
}
