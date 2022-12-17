package br.com.gestao_escola.persistencia.converte;

import br.com.gestao_escola.dominio.entidade.disciplina.Turma;
import br.com.gestao_escola.persistencia.entidade.TurmaEntidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TurmaConverte {
    private final ModelMapper modelMapper;

    public Turma converteEntidadeToTurma(TurmaEntidade turmaEntidade) {
        return modelMapper.map(turmaEntidade, Turma.class);
    }

    public TurmaEntidade converteTurmaToEntidade(Turma turma) {
        return modelMapper.map(turma, TurmaEntidade.class);
    }
}