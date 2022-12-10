package br.com.gestao_escola.entidade.professor;

import br.com.gestao_escola.entidade.aluno.Nota;
import br.com.gestao_escola.entidade.disciplina.Disciplina;
import br.com.gestao_escola.entidade.objetos.*;
import lombok.Data;

import java.time.Year;

@Data
public class Professor  extends Pessoa {

    private final String perfil = "PROFESSOR";

    private final String matricula = "PROF" + Year.now().getValue() + this.getCpf().getNumero();

    private Disciplina disciplina;


    public Professor(String nome, String sobrenome, Telefone telefone, Endereco endereco, Cpf cpf, Email email) {
        super(nome, sobrenome, telefone, endereco, cpf, email);
    }

    public Professor(String nome, String sobrenome, Cpf cpf) {
        super(nome, sobrenome, cpf);
    }

    public Professor(Disciplina disciplina) {
        super();
        this.disciplina = disciplina;
    }


    public Professor(){
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
