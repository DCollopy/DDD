package br.com.gestao_escola.persistencia.converte;

import br.com.gestao_escola.dominio.entidade.aluno.Falta;
import br.com.gestao_escola.persistencia.entidade.FaltaEntidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FaltaConverte {
    private final ModelMapper modelMapper;

    public Falta converteEntitidadeToFalta(FaltaEntidade faltaEntidade) {
        return modelMapper.map(faltaEntidade, Falta.class);
    }

    public FaltaEntidade converteFaltaToEntidade(Falta falta) {
        return modelMapper.map(falta, FaltaEntidade.class);
    }
}