package br.com.gestao_escola.dominio.entidade.responsavel;

import br.com.gestao_escola.dominio.entidade.objetos.*;

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
    public String pegaMatricula() {
        return this.perfil;
    }
}
