package br.com.gestao_escola.kafka.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ResponsavelDTO extends PessoaDTO {

    private String perfil;
    public ResponsavelDTO() {
        super();
    }
}