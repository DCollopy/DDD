package br.com.gestao_escola.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminDTO extends PessoaDTO {

    private String matricula;
    private String perfil;

    public AdminDTO() {
        super();
    }
}