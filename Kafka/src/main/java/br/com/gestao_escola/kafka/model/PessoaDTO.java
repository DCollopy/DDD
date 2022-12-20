package br.com.gestao_escola.kafka.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
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
