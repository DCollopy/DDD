package br.com.gestao_escola.persistencia.converte;

import br.com.gestao_escola.dominio.entidade.responsavel.Responsavel;
import br.com.gestao_escola.persistencia.entidade.ResponsavelEntidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResponsavelConverte {

    private final ModelMapper modelMapper;

    public Responsavel converteEntidadeToResponsavel(ResponsavelEntidade responsavelEntidade) {
        return modelMapper.map(responsavelEntidade, Responsavel.class);
    }

    public ResponsavelEntidade converteResponsavelToEntidade(Responsavel responsavel) {
        return modelMapper.map(responsavel, ResponsavelEntidade.class);
    }
}
