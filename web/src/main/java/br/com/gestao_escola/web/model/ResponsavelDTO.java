package br.com.gestao_escola.web.model;

import br.com.gestao_escola.dominio.entidade.responsavel.Responsavel;

public class ResponsavelDTO extends PessoaDTO {

    public Responsavel converteDtoParaResponsavel() {
        return new Responsavel(this.getNome()
                , this.getSobrenome()
                , this.getTelefone().converteDtoParaTelefone()
                , this.getEndereco().converteDtoParaEndereco()
                , this.getCpf().converteDtoParaCpf()
                , this.getEmail().converteDtoParaEmail()
        );
    }

}
