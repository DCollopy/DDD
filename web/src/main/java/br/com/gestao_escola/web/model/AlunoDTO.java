package br.com.gestao_escola.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlunoDTO extends PessoaDTO {

    private String matricula;

    private String perfil;

    private Set<FaltaDTO> falta;

    private Set<TurmaDTO> turma;

    private ResponsavelDTO responsavel;

    public AlunoDTO() {
        super();
    }
}