package br.com.gestao_escola.persistencia.service.admin;

import br.com.gestao_escola.dominio.entidade.admin.Admin;
import br.com.gestao_escola.dominio.entidade.objetos.Cpf;
import br.com.gestao_escola.dominio.entidade.servico.AdminService;
import br.com.gestao_escola.persistencia.converte.AdminConverte;
import br.com.gestao_escola.persistencia.converte.CpfConverte;
import br.com.gestao_escola.persistencia.repositorio.AdminRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class AdminIml implements AdminService {
    private final AdminRepositorio adminRepositorio;
    private final AdminConverte adminConverte;
    private final CpfConverte cpfConverte;
    private AdminValidaAbs adminValidaAbs = new AdminValidaAbs();

    public AdminIml(AdminRepositorio adminRepositorio, AdminConverte adminConverte, CpfConverte cpfConverte) {
        this.adminRepositorio = adminRepositorio;
        this.adminConverte = adminConverte;
        this.cpfConverte = cpfConverte;
    }
    @Override
    public void salva(Admin admin) {
        adminValidaAbs.criaAdmin(admin);
        adminRepositorio.save(adminConverte.converteAdminToEntidade(admin));
    }

    @Override
    public Admin buscaPorCpf(Cpf cpf) {
        return adminConverte
                .converteEntitidadeToAdmin(adminRepositorio.findOnesByCpf(cpfConverte.converteCpfToEntidade(cpf)));
    }

    @Override
    public void deleta(Cpf cpf) {
        try {
            Admin admin = buscaPorCpf(cpf);
            if (admin != null) {
                Logger.getLogger("Admin").info("Admin deletado com sucesso" + admin.getNome());
                adminRepositorio.delete(adminConverte.converteAdminToEntidade(admin));
            } else {
                Logger.getLogger("Admin").info("Admin não encontrado" + admin.getNome());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover admin");
        }
    }

    @Override
    public void edita(Admin admin) {
        if (buscaPorCpf(admin.getCpf()) != null) {
            adminValidaAbs.editAdmin(admin);
            adminRepositorio.save(adminConverte.converteAdminToEntidade(admin));
            Logger.getLogger("Admin").info("Admin editado com sucesso" + admin.getNome());
        } else {
            Logger.getLogger("Admin").info("Admin não encontrado" + admin.getNome());
        }
    }

    @Override
    public List<Admin> listAll() {
        return adminRepositorio.findAll().stream().map(adminConverte::converteEntitidadeToAdmin).collect(Collectors.toList());
    }
}