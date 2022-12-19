package br.com.gestao_escola.persistencia.converte;

import br.com.gestao_escola.dominio.entidade.aluno.Nota;
import br.com.gestao_escola.persistencia.entidade.NotaEntidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotaConverte {
    private final ModelMapper modelMapper;
    public Nota converteEntidadeToNota(NotaEntidade notaEntidade) {
        return modelMapper.map(notaEntidade, Nota.class);
    }

    public NotaEntidade converteNotaToEntidade(Nota nota) {
        return modelMapper.map(nota, NotaEntidade.class);
    }
}