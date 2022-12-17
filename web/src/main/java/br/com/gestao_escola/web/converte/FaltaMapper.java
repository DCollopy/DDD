package br.com.gestao_escola.web.converte;

import br.com.gestao_escola.dominio.entidade.aluno.Falta;
import br.com.gestao_escola.web.model.FaltaDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FaltaMapper {

    private final ModelMapper modelMapper;

    public Falta converteDTOToAluno(FaltaDTO faltaDTO) {
        return modelMapper.map(faltaDTO, Falta.class);
    }

    public FaltaDTO converteAlunoToDTO(Falta falta) {
        return modelMapper.map(falta, FaltaDTO.class);
    }
}