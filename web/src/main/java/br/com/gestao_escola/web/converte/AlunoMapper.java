package br.com.gestao_escola.web.converte;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.web.model.AlunoDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlunoMapper {
    private final ModelMapper modelMapper;

    public Aluno converteDTOToAluno(AlunoDTO alunoDTO) {
        return modelMapper.map(alunoDTO, Aluno.class);
    }

    public AlunoDTO converteAlunoToDTO(Aluno aluno) {
        return modelMapper.map(aluno, AlunoDTO.class);
    }
}
