package br.com.gestao_escola.dominio.casodeuso.professor;

import br.com.gestao_escola.dominio.entidade.professor.Professor;

public abstract class ProfessorValida {

    public Professor criaProfessor(Professor professor) {
        try {
            if(professor.getMatricula() != null){
                return new Professor(professor.getNome(), professor.getSobrenome(), professor.getCpf());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
        return professor;
    }

}
