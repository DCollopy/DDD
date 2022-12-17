package br.com.gestao_escola.dominio.entidade.admin;

import br.com.gestao_escola.dominio.entidade.objetos.Cpf;
import br.com.gestao_escola.dominio.entidade.objetos.Pessoa;
import lombok.Data;

import java.time.Year;
@Data
public class Admin extends Pessoa {
    private final String matricula = "ADMIN" + Year.now().getValue() + this.getCpf().getCpf();
    private final String perfil = "ADMIN";

    public Admin(String nome, String sobrenome, Cpf cpf) {
        super(nome, sobrenome, cpf);
    }

    public Admin(){
        super();
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
