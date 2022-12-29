package br.com.gestao_escola.casodeuso.admin;

import br.com.gestao_escola.dominio.casodeuso.admin.AdminValidaTeste;
import br.com.gestao_escola.dominio.entidade.admin.Admin;
import br.com.gestao_escola.dominio.entidade.objetos.Cpf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTeste {

    protected AdminValidaTeste adminValida = new AdminValidaTeste();

    Admin admin = new Admin("admin", "admin"
            ,new Cpf("12345678910"));

    @Test
    void criaAdmin() {
       assertNotNull(adminValida.criaAdmin(admin));
    }

    @Test
    void editAdmin() {
        admin.setNome("admin2");
        adminValida.editAdmin(admin);
        assertEquals("admin2", admin.getNome());
    }
}