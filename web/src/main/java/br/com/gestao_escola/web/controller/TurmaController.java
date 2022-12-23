package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.disciplina.Turma;
import br.com.gestao_escola.dominio.entidade.servico.AlunoService;
import br.com.gestao_escola.dominio.entidade.servico.TurmaService;
import br.com.gestao_escola.web.converte.AlunoMapper;
import br.com.gestao_escola.web.converte.TurmaMapper;
import br.com.gestao_escola.web.model.TurmaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escola/turma")
public class TurmaController {
    private final TurmaService turmaService;
    private final TurmaMapper turmaMapper;

    private final AlunoService alunoService;

    private final AlunoMapper alunoMapper;

    public TurmaController(TurmaService turmaService, TurmaMapper turmaMapper
            , AlunoService alunoService, AlunoMapper alunoMapper) {
        this.turmaService = turmaService;
        this.turmaMapper = turmaMapper;
        this.alunoService = alunoService;
        this.alunoMapper = alunoMapper;
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
    public String createTurma(@RequestBody TurmaDTO turma, @PathVariable String identidade,@RequestParam String cpf) {
        turma.setAluno(List.of(alunoMapper.converteAlunoToDTO(alunoService.findOne(cpf))));
        turmaService.save(turmaMapper.converteDTOToTurma(turma), identidade);
        return "redirect:/turma";
    }

    @PutMapping("/edita/{id}/{identidade}")
    public String editTurma(@PathVariable int id, @PathVariable String identidade, @RequestBody TurmaDTO turma) {
        turmaService.edit(id, identidade,turmaMapper.converteDTOToTurma(turma));
        return "redirect:/turma";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTurma(@PathVariable int id) {
        turmaService.delete(turmaService.findById(id));
        return "redirect:/turma";
    }
}