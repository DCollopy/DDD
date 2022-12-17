package br.com.gestao_escola.dominio.casodeuso.responsavel;

import br.com.gestao_escola.dominio.entidade.responsavel.Responsavel;

import java.util.logging.Logger;

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

    public Responsavel editaResponsavel(Responsavel responsavel){
        try {
            valida(responsavel);
            Logger.getLogger("Responsavel").info("Responsavel editada com sucesso");
            return new Responsavel(responsavel.getNome(),responsavel.getSobrenome(),responsavel.getTelefone()
                    ,responsavel.getEndereco(),responsavel.getCpf(),responsavel.getEmail());
        } catch (Exception e) {
            Logger.getLogger("Responsavel").info("Responsavel não editada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }
}
