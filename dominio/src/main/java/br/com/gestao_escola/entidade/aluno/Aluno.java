package br.com.gestao_escola.entidade.aluno;

import br.com.gestao_escola.entidade.disciplina.Turma;
import br.com.gestao_escola.entidade.objetos.*;
import lombok.Data;

import java.time.Year;

@Data
public class Aluno extends Pessoa {

    private final String matricula = "ALU" + Year.now().getValue() + this.getCpf().getNumero();

    private final String perfil = "ALUNO";

    private Turma turma;

    private Falta falta;

    public Aluno(String nome, String sobrenome, Telefone telefone, Endereco endereco, Cpf cpf, Email email) {
        super(nome, sobrenome, telefone, endereco, cpf, email);
    }

    public Aluno(String nome, String sobrenome, Cpf cpf) {
        super(nome, sobrenome, cpf);
    }


    public Aluno() {
        super();
    }


    @Override
    public String perfil() {
        return this.perfil;
    }

    @Override
    public String geraMatricula() {
        return this.matricula;
    }

}
