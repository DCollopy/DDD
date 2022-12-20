package br.com.gestao_escola.kafka.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@SuperBuilder
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