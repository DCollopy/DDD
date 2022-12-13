package br.com.gestao_escola.web.model;

import br.com.gestao_escola.dominio.entidade.objetos.Email;
import lombok.Data;

@Data
public class EmailDTO {

    private String email;

    public EmailDTO() {
    }

    public Email converteDtoParaEmail() {
        return new Email(this.getEmail());
    }
}
