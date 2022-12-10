package br.com.gestao_escola.entidade.objetos;

import lombok.Data;

@Data
public abstract class Pessoa {

    private String nome;
    private String sobrenome;

    private Telefone telefone;

    private Endereco endereco;

    private Cpf cpf;

    private Email email;


    public Pessoa(String nome, String sobrenome, Telefone telefone, Endereco endereco, Cpf cpf, Email email) {

        if(nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");

        }
        if(sobrenome == null || sobrenome.isEmpty()) {
            throw new IllegalArgumentException("Sobrenome não pode ser nulo ou vazio");
        }
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.email = email;
    }

    public Pessoa(String nome, String sobrenome, Cpf cpf) {

        if(nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");

        }
        if(sobrenome == null || sobrenome.isEmpty()) {
            throw new IllegalArgumentException("Sobrenome não pode ser nulo ou vazio");
        }
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public Pessoa(){
    }

    public abstract String perfil();

    public abstract String geraMatricula();
}
