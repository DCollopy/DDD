package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.admin.Admin;
import br.com.gestao_escola.dominio.entidade.objetos.Cpf;

import java.util.List;

public interface AdminService {

    void salva(Admin admin);

    Admin buscaPorCpf(Cpf cpf);

    void edita(Admin admin);

    List<Admin> listAll();

    void deleta(Cpf cpf);
}