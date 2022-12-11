package br.com.gestao_escola.casodeuso.aluno;

import br.com.gestao_escola.entidade.aluno.Aluno;
import br.com.gestao_escola.entidade.objetos.Cpf;

import java.util.logging.Logger;

public abstract class AlunoValida {

    public Aluno criaAluno(Aluno aluno) {
        try {
            return new Aluno(aluno.getNome(), aluno.getSobrenome(), aluno.getTelefone(), aluno.getEndereco()
                    , aluno.getCpf(), aluno.getEmail());
        } catch (Exception e) {
            Logger.getLogger("Aluno").info("Aluno nao criada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }

    public Aluno editAluno(Aluno aluno, Cpf cpf) {
        try {
            if (cpf.equals(aluno.getCpf())) {
                Logger.getLogger("Aluno").info("Aluno editada com sucesso");
                return new Aluno(aluno.getNome(), aluno.getSobrenome(), aluno.getTelefone(), aluno.getEndereco()
                        , aluno.getCpf(), aluno.getEmail());
            }
            Logger.getLogger("Aluno").info("Aluno nao editada");
            throw new IllegalArgumentException("Aluno nao editada");
        } catch (Exception e) {
            Logger.getLogger("Aluno").info("Aluno nao editada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }
}
