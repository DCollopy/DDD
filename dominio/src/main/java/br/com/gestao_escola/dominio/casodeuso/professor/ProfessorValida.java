package br.com.gestao_escola.dominio.casodeuso.professor;

import br.com.gestao_escola.dominio.entidade.professor.Professor;

import java.util.logging.Logger;

public abstract class ProfessorValida {

    public Professor criaProfessor(Professor professor) {
        try {
            Logger.getLogger("Professor").info("Professor criado com sucesso");
            return new Professor(professor.getNome(), professor.getSobrenome(), professor.getCpf());
        } catch (Exception e) {
            Logger.getLogger("Professor").info("Professor não criado");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }

    public Professor editaProfessor(Professor professor) {
        try {
            Logger.getLogger("Professor").info("Professor criado com sucesso");
            return new Professor(professor.getNome(), professor.getSobrenome(), professor.getCpf());
        } catch (Exception e) {
            Logger.getLogger("Professor").info("Professor não criado");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }
}