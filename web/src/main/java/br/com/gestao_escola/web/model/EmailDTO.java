package br.com.gestao_escola.web.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class EmailDTO {

    private String email;
    public EmailDTO() {
    }
}