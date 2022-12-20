package br.com.gestao_escola.kafka.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class TelefoneDTO {

    private String ddd;

    private String numero_telefone;

    public TelefoneDTO() {
    }
}