package br.com.gestao_escola.kafka.model;


import lombok.Data;

@Data
public class AdminDTO extends PessoaDTO {

    private String matricula;
    private String perfil;

    public AdminDTO() {
        super();
    }
}