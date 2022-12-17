package br.com.gestao_escola.dominio.casodeuso.admin;

import br.com.gestao_escola.dominio.entidade.admin.Admin;

import java.util.logging.Logger;

public abstract class AdminValida {

    public Admin criaAdmin(Admin admin) {
        try {
            Logger.getLogger("Admin").info("Admin criado com sucesso");
            return new Admin(admin.getNome(), admin.getSobrenome(),admin.getCpf());
        }  catch (Exception e) {
            Logger.getLogger("Admin").info("Admin nao criada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }

    public void editAdmin(Admin admin) {
        try {
            new Admin(admin.getNome(), admin.getSobrenome(),admin.getCpf());
            Logger.getLogger("Admin").info("Admin editada com sucesso");
        } catch (Exception e) {
            Logger.getLogger("Admin").info("Admin nao editada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }
}