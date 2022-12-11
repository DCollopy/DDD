package br.com.gestao_escola.casodeuso.aluno;

import br.com.gestao_escola.entidade.aluno.Aluno;

public abstract class AlunoValida {

    public Aluno criaAluno(Aluno aluno){
        try {
            return new Aluno(aluno.getNome(),aluno.getSobrenome(),aluno.getTelefone(),aluno.getEndereco()
                    ,aluno.getCpf(),aluno.getEmail());
        } catch (Exception e) {
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }

}
