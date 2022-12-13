package br.com.gestao_escola.web.model;

import lombok.Data;

@Data
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
