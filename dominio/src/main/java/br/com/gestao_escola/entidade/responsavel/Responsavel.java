package br.com.gestao_escola.entidade.responsavel;

import br.com.gestao_escola.entidade.generico.*;
import lombok.Data;

@Data
public class Responsavel extends Pessoa {
    private final String perfil = "RESPONSAVEL";

    public Responsavel() {
        super();
    }

    public Responsavel(String nome, String sobrenome, Telefone telefone, Endereco endereco, Cpf cpf, Email email) {
        super(nome, sobrenome, telefone, endereco, cpf, email);
    }

    @Override
    public String perfil() {
        return this.perfil;
    }

    @Override
    public String geraMatricula() {
        return this.perfil;
    }
}
