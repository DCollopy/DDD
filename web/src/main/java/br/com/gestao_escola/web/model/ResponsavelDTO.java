package br.com.gestao_escola.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponsavelDTO extends PessoaDTO {

    private String perfil;
    public ResponsavelDTO() {
        super();
    }
}