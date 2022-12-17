package br.com.gestao_escola.dominio.casodeuso.aluno;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import java.util.logging.Logger;

public abstract class AlunoValida {

    public Aluno criaAluno(Aluno aluno) {
        try {
            Logger.getLogger("Aluno").info("Aluno criado com sucesso");
            return new Aluno(aluno.getNome(), aluno.getSobrenome(), aluno.getTelefone(), aluno.getEndereco()
                    , aluno.getCpf(), aluno.getEmail(), aluno.getResponsavel());
        } catch (Exception e) {
            Logger.getLogger("Aluno").info("Aluno nao criada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }

    public Aluno editAluno(Aluno aluno) {
        try {
            Logger.getLogger("Aluno").info("Aluno editada com sucesso");
            return new Aluno(aluno.getNome(), aluno.getSobrenome(), aluno.getTelefone(), aluno.getEndereco()
                    , aluno.getCpf(), aluno.getEmail(), aluno.getResponsavel());

        } catch (Exception e) {
            Logger.getLogger("Aluno").info("Aluno nao editada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }
}