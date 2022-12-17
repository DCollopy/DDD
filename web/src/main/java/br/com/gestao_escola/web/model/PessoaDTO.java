package br.com.gestao_escola.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaDTO {

    private String nome;

    private String sobrenome;

    private TelefoneDTO telefone;

    private EnderecoDTO endereco;

    private CpfDTO cpf;

    private EmailDTO email;

    public PessoaDTO() {
    }
}
