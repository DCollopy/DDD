package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.professor.Professor;
import br.com.gestao_escola.dominio.entidade.servico.ProfessorService;
import br.com.gestao_escola.web.converte.CpfMapper;
import br.com.gestao_escola.web.converte.ProfessorMapper;
import br.com.gestao_escola.web.model.CpfDTO;
import br.com.gestao_escola.web.model.ProfessorDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escola/professor")
public class ProfessorController {
    private final ProfessorService professorService;
    private final ProfessorMapper professorMapper;
    private final CpfMapper cpfMapper;

    public ProfessorController(ProfessorService professorService, ProfessorMapper professorMapper, CpfMapper cpfMapper) {
        this.professorService = professorService;
        this.professorMapper = professorMapper;
        this.cpfMapper = cpfMapper;
    }

    @GetMapping
    public List<Professor> index() {
        return professorService.listAll();
    }

    @GetMapping({ "/{cpf}" })
    public void index(@PathVariable String cpf) {
        professorService.findOne(cpf);
    }

    @PostMapping("/criaProfessor")
    public void createProfessor(@RequestBody ProfessorDTO professorDTO) {
        professorService.save(professorMapper.converteDTOToProfessor(professorDTO));
    }

    @PutMapping("/edita/{cpf}")
    public void editProfessor(@RequestBody ProfessorDTO professorDTO) {
        professorService.edit(professorMapper.converteDTOToProfessor(professorDTO));
    }

    @DeleteMapping("/delete/{cpf}")
    public void deleteProfessor(@PathVariable String cpf) {
        professorService.delete(cpf);
    }
}