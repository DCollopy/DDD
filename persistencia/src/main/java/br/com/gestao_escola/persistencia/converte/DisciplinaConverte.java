package br.com.gestao_escola.persistencia.converte;

import br.com.gestao_escola.dominio.entidade.disciplina.Disciplina;
import br.com.gestao_escola.persistencia.entidade.DisciplinaEntidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DisciplinaConverte {

    private final ModelMapper modelMapper;

    public Disciplina converteEntitidadeToDisciplina(DisciplinaEntidade disciplinaEntidade) {
        return modelMapper.map(disciplinaEntidade, Disciplina.class);
    }

    public DisciplinaEntidade converteDisciplinaToEntidade(Disciplina disciplina) {
        return modelMapper.map(disciplina, DisciplinaEntidade.class);
    }
}