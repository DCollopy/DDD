package br.com.gestao_escola.web.converte;

import br.com.gestao_escola.dominio.entidade.aula.Aula;
import br.com.gestao_escola.web.model.AulaDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AulaMapper {
    private final ModelMapper modelMapper;

    public Aula converteDTOToAula(AulaDTO aulaDTO) {
        return modelMapper.map(aulaDTO, Aula.class);
    }

    public AulaDTO converteAulaToDTO(Aula aula) {
        return modelMapper.map(aula, AulaDTO.class);
    }
}