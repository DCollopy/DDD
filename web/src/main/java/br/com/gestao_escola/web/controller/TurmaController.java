package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.disciplina.Turma;
import br.com.gestao_escola.dominio.entidade.servico.TurmaService;
import br.com.gestao_escola.web.converte.TurmaMapper;
import br.com.gestao_escola.web.model.TurmaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escola/turma")
public class TurmaController {
    private final TurmaService turmaService;
    private final TurmaMapper turmaMapper;

    public TurmaController(TurmaService turmaService, TurmaMapper turmaMapper) {
        this.turmaService = turmaService;
        this.turmaMapper = turmaMapper;
    }

    @GetMapping
    public List<Turma> index() {
        return turmaService.findAll();
    }

    @GetMapping({ "/{id}}" })
    public Turma index(@PathVariable int id)  {
        return turmaService.findById(id);
    }

    @PostMapping("/criaTurma/{identidade}")
    public String createTurma(@RequestBody TurmaDTO turma, @PathVariable String identidade) {
        turmaService.save(turmaMapper.converteDTOToTurma(turma), identidade);
        return "redirect:/turma";
    }

    @PutMapping("/edita/{id}")
    public String editTurma(@PathVariable int id, @PathVariable String identidade) {
        turmaService.edit(turmaService.findById(id), identidade);
        return "redirect:/turma";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTurma(@PathVariable int id) {
        turmaService.delete(turmaService.findById(id));
        return "redirect:/turma";
    }
}