package br.com.gestao_escola.entidade.admin;

import br.com.gestao_escola.entidade.objetos.Cpf;
import br.com.gestao_escola.entidade.objetos.Pessoa;
import lombok.Data;

import java.time.Year;
@Data
public class Admin extends Pessoa {

    private final String matricula = "ADMIN" + Year.now().getValue() + this.getCpf().getNumero();
    private final String perfil = "ADMIN";

    public Admin(String nome, String sobrenome, Cpf cpf) {
        super(nome, sobrenome, cpf);
    }


    @Override
    public String perfil() {
        return this.perfil;
    }

    @Override
    public String pegaMatricula() {
        return this.matricula;
    }
}
