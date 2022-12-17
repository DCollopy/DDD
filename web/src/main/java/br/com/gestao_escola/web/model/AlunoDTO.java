package br.com.gestao_escola.web.model;

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
}