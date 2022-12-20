package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.disciplina.Disciplina;
import br.com.gestao_escola.dominio.entidade.servico.DisciplinaService;
import br.com.gestao_escola.web.converte.DisciplinaMapper;
import br.com.gestao_escola.web.model.DisciplinaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escola/disciplina")
public class DisciplinaController {
    private final DisciplinaService disciplinaService;
    private final DisciplinaMapper disciplinaMapper;

    public DisciplinaController(DisciplinaService disciplinaService, DisciplinaMapper disciplinaMapper) {
        this.disciplinaService = disciplinaService;
        this.disciplinaMapper = disciplinaMapper;
    }

    @GetMapping
    public List<Disciplina> index() {
        return disciplinaService.listAll();
    }

    @GetMapping({ "/{id}" })
    public Disciplina index(@PathVariable int id) {
        return disciplinaService.findOne(id);
    }

    @PostMapping("/criaDisciplina")
    public void createDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        disciplinaService.save(disciplinaMapper.converteDTOToDisciplina(disciplinaDTO));
    }

    @PutMapping("/editaDisciplina/{id}")
    public void editDisciplina(@PathVariable int id) {
        disciplinaService.edit(disciplinaService.findOne(id));
    }

    @DeleteMapping("/deletaDisciplina/{id}")
    public void deleteDisciplina(@PathVariable int id) {
        disciplinaService.delete(id);
    }
}
