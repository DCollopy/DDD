package br.com.gestao_escola.persistencia.converte;

import br.com.gestao_escola.dominio.entidade.professor.Professor;
import br.com.gestao_escola.persistencia.entidade.ProfessorEntidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfessorConverte {
    private final ModelMapper modelMapper;

    public Professor converteEntitidadeToProfessor(ProfessorEntidade professorEntidade) {
        return modelMapper.map(professorEntidade, Professor.class);
    }

    public ProfessorEntidade converteProfessorToEntidade(Professor professor) {
        return modelMapper.map(professor, ProfessorEntidade.class);
    }
}