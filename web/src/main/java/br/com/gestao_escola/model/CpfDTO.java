package br.com.gestao_escola.model;

import br.com.gestao_escola.entidade.objetos.Cpf;
import lombok.Data;

@Data
public class CpfDTO {

    private String cpf;

    public CpfDTO() {
    }

    public Cpf converteDtoParaCpf() {
        return new Cpf(this.getCpf());
    }
}
