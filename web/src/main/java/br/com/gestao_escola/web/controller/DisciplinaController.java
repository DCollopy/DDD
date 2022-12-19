package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.servico.DisciplinaService;
import br.com.gestao_escola.web.converte.DisciplinaMapper;
import br.com.gestao_escola.web.model.DisciplinaDTO;
import org.springframework.web.bind.annotation.*;

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
    public void index() {
        disciplinaService.listAll();
    }

    @GetMapping({ "/{id}" })
    public void index(@PathVariable Long id) {
        disciplinaService.findOne(id);
    }

    @PostMapping("/criaDisciplina")
    public void createDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        disciplinaService.save(disciplinaMapper.converteDTOToDisciplina(disciplinaDTO));
    }

    @PutMapping("/editaDisciplina/{id}")
    public void editDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        disciplinaService.edit(disciplinaMapper.converteDTOToDisciplina(disciplinaDTO));
    }

    @DeleteMapping("/deletaDisciplina/{id}")
    public void deleteDisciplina(@PathVariable Long id) {
        disciplinaService.delete(id);
    }
}
