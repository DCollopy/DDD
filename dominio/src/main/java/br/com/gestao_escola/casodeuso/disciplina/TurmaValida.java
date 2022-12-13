package br.com.gestao_escola.casodeuso.disciplina;

import br.com.gestao_escola.entidade.aluno.Aluno;
import br.com.gestao_escola.entidade.disciplina.Turma;

import java.util.List;
import java.util.logging.Logger;

public abstract class TurmaValida {

    public Turma criaTurma(Turma turma, String admin) {
        try {
            if (admin.contains("ADMIN") && turma.getQuantidade_alunos() < turma.getLimite_alunos()) {
                Logger.getLogger("Turma").info("Turma criada com sucesso");
                return new Turma(turma.getNome(), turma.getDescricao(), turma.getData_inicio(),
                        turma.getData_fim());
            } else {
                Logger.getLogger("Turma").info("Turma nao criada");
                throw new IllegalArgumentException("Turma invalida");
            }
        } catch (Exception e) {
            Logger.getLogger("Turma").info("Turma nao criada");
            throw new IllegalArgumentException("Turma invalida");
        }
    }
    public Turma editaTurma(Turma turma, String admin) {
        try {
            if (admin.contains("ADMIN")) {
                Logger.getLogger("Turma").info("Turma editada com sucesso");
                return new Turma(turma.getNome(), turma.getDescricao(), turma.getData_inicio(),
                        turma.getData_fim());
            } else {
                Logger.getLogger("Turma").info("Turma nao encotrada para edicao");
                throw new IllegalArgumentException("Turma invalida");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Turma invalida");
        }
    }
    public Turma insereAlunoTurma(Turma turma, Aluno aluno, String admin) {
        try {
            if (admin.contains("ADMIN") && turma.getQuantidade_alunos() < turma.getLimite_alunos()) {
                turma.setQuantidade_alunos(turma.getQuantidade_alunos() + 1);
                List<Aluno> addAluno = List.of(aluno);
                turma.setAluno(addAluno);
                Logger.getLogger("Turma").info("Aluno inserido na turma");
                return turma;
            } else {
                Logger.getLogger("Turma").info("Turma nao encotrada para inserir aluno");
                throw new IllegalArgumentException("Turma invalida");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Turma invalida");
        }
    }

    public void turmaAtiva(Turma turma, String admin) {
        try {
            if (admin.contains("ADMIN") && turma.getQuantidade_alunos() == turma.getLimite_alunos() / 2) {
                turma.setTurmaAtiva(true);
                Logger.getLogger("Turma").info("Turma ativada");
            } else {
                Logger.getLogger("Turma").info("Turma nao encotrada para ativar");
                throw new IllegalArgumentException("Turma invalida");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Turma invalida");
        }
    }

    public boolean turmaContemAluno(Turma turma, Aluno aluno) {
        if (turma.getAluno().contains(aluno)) {
            Logger.getLogger("Turma").info("Aluno encontrado na turma");
            return true;
        } else {
            Logger.getLogger("Turma").info("Aluno nao encontrado na turma");
            return false;
        }
    }
}
