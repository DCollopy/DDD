package br.com.gestao_escola.casodeuso.responsavel;

import br.com.gestao_escola.entidade.responsavel.Responsavel;

public abstract class ResponsavelValida {

    public void valida(Responsavel responsavel){
        if(responsavel.pegaMatricula() == null || responsavel.pegaMatricula().isEmpty()){
            throw new IllegalArgumentException("Matricula não foi gerada");
        }
    }

    public Responsavel criaResponsavel(Responsavel responsavel){
        try {
            valida(responsavel);
            return new Responsavel(responsavel.getNome(),responsavel.getSobrenome(),responsavel.getTelefone()
                                  ,responsavel.getEndereco(),responsavel.getCpf(),responsavel.getEmail());
        } catch (Exception e) {
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }
}
