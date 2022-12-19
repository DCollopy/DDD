package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.admin.Admin;
import br.com.gestao_escola.dominio.entidade.servico.AdminService;
import br.com.gestao_escola.web.converte.AdminMapper;
import br.com.gestao_escola.web.converte.CpfMapper;
import br.com.gestao_escola.web.model.CpfDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escola/admin")
public class AdminController {
    private final AdminService adminService;
    private final AdminMapper adminMapper;

    public AdminController(AdminService adminService, AdminMapper adminMapper) {
        this.adminService = adminService;
        this.adminMapper = adminMapper;
    }

    @GetMapping
    public List<Admin> admin() {
        return adminService.listAll();
    }

    @GetMapping({ "/{cpf}" })
    public Admin admin(@PathVariable String cpf) {
        return adminService.buscaPorCpf(cpf);
    }

    @PostMapping("/criaAdmin")
    public String createAdmin(@RequestBody Admin admin) {
        adminService.salva(admin);
        return "redirect:/admin";
    }

    @PutMapping("/edita/{cpf}")
    public String editAdmin(@RequestBody Admin admin) {
        adminService.edita(admin);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{cpf}")
    public String deleteAdmin(@PathVariable String cpf) {
        adminService.deleta(cpf);
        return "redirect:/admin";
    }
}