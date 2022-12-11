package br.com.gestao_escola.casodeuso.disciplina;

import br.com.gestao_escola.entidade.disciplina.Disciplina;

import java.util.logging.Logger;

public abstract class DisciplinaValida {

    public Disciplina criaDisciplina(Disciplina disciplina) {
        try {
            return new Disciplina(disciplina.getAula(), disciplina.getTurma(), disciplina.getProfessor());
        } catch (Exception e) {
            Logger.getLogger("Disciplina").info("Disicplina nao criada");
            throw new IllegalArgumentException("Disciplina invalida");
        }
    }

    public Disciplina editaDisciplina(Disciplina disciplina, long id){
        try {
            if (disciplina.getId() == id) {
                Logger.getLogger("Disciplina").info("Disciplina editada com sucesso");
                return new Disciplina(disciplina.getAula(), disciplina.getTurma(), disciplina.getProfessor());
            } else {
                Logger.getLogger("Disciplina").info("Disciplina nao encotrada para edicao");
                throw new IllegalArgumentException("Disciplina invalida");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Disciplina invalida");
        }
    }

    public void deletaDisciplina(Disciplina disciplina, long id){
        try {
            if (disciplina.getId() == id) {
                Logger.getLogger("Disciplina").info("Disciplina deletada");
            } else {
                Logger.getLogger("Disciplina").info("Disciplina nao encotrada para deletar");
                throw new IllegalArgumentException("Disciplina invalida");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Disciplina invalida");
        }
    }
}
