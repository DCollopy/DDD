package br.com.gestao_escola.dominio.entidade.aluno;

import br.com.gestao_escola.dominio.entidade.objetos.*;
import br.com.gestao_escola.dominio.entidade.responsavel.Responsavel;
import br.com.gestao_escola.dominio.entidade.disciplina.Turma;
import lombok.Data;

import java.time.Year;
import java.util.Set;
import java.util.logging.Logger;

@Data
public class Aluno extends Pessoa {
    private final String matricula = "ALU" + Year.now().getValue() +(int) (Math.random() * 1000);
    private final String perfil = "ALUNO";

    private Set<Falta> falta;
    private Set<Turma> turma;

    private Set<Nota> nota;
    private Responsavel responsavel;

    public Aluno(String nome, String sobrenome, Telefone telefone, Endereco endereco, Cpf cpf, Email email, Responsavel responsavel) {
        super(nome, sobrenome, telefone, endereco, cpf, email);
        if (responsavel == null) {
            Logger.getLogger("Aluno").info("Responsavel nao pode ser nulo");
            throw new IllegalArgumentException("Responsavel nao pode ser nulo");
        }
        this.responsavel = responsavel;
    }

    public Aluno(String nome, String sobrenome, Cpf cpf, Responsavel responsavel) {
        super(nome, sobrenome, cpf);
        if (responsavel == null) {
            Logger.getLogger("Aluno").info("Responsavel nao pode ser nulo");
            throw new IllegalArgumentException("Responsavel nao pode ser nulo");
        }
        this.responsavel = responsavel;
    }

    public Aluno()  {
        super();
    }

    public Aluno(Set<Turma> turma) {
        this.turma = turma;
    }

    @Override
    public String perfil() {
        return this.perfil;
    }

    @Override
    public String pegaMatricula() {
        return this.matricula;
    }

    public Cpf getCpf() {
        return super.getCpf();
    }
}
