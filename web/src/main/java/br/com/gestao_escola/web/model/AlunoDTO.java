package br.com.gestao_escola.web.model;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlunoDTO extends PessoaDTO {

    private TurmaDTO turma;

    private ResponsavelDTO responsavel;

    public AlunoDTO() {
        super();
    }

    public Aluno converteDtoParaAluno() {
        return new Aluno(this.getNome()
                , this.getSobrenome()
                , this.getTelefone().converteDtoParaTelefone()
                , this.getEndereco().converteDtoParaEndereco()
                , this.getCpf().converteDtoParaCpf()
                , this.getEmail().converteDtoParaEmail()
                , this.getResponsavel().converteDtoParaResponsavel()
        );
    }

    public Aluno converteDtoParaAlunoTurma() {
        return new Aluno(this.getTurma().converteDtoParaTurma());
    }

    public Aluno convertDtoParaAlunoEntradaSimples() {
        return new Aluno(this.getNome()
                , this.getSobrenome()
                , this.getCpf().converteDtoParaCpf()
                ,this.getResponsavel().converteDtoParaResponsavel()
        );
    }
}
