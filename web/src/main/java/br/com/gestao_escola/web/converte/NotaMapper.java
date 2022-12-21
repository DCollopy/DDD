package br.com.gestao_escola.web.converte;

import br.com.gestao_escola.dominio.entidade.aluno.Nota;
import br.com.gestao_escola.web.model.NotaDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotaMapper {

    private final ModelMapper modelMapper;

    public Nota converteDTOToNota(NotaDTO notaDTO) {
        return modelMapper.map(notaDTO, Nota.class);
    }

    public NotaDTO converteNotaToDTO(Nota nota) {
        return modelMapper.map(nota, NotaDTO.class);
    }


}