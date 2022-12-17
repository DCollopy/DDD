package br.com.gestao_escola.persistencia.converte;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.persistencia.entidade.AlunoEntidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlunoConverte {

    private final ModelMapper modelMapper;
    public Aluno converteEntitidadeToAluno(AlunoEntidade alunoEntidade) {
        return modelMapper.map(alunoEntidade, Aluno.class);
    }

    public AlunoEntidade converteAlunoToEntidade(Aluno aluno) {

        return modelMapper.map(aluno, AlunoEntidade.class);
    }
}
