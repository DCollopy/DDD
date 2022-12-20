package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.aluno.Falta;
import br.com.gestao_escola.dominio.entidade.servico.FaltaService;
import br.com.gestao_escola.web.converte.FaltaMapper;
import br.com.gestao_escola.web.model.FaltaDTO;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/escola/falta")
public class FaltaController {
    private final FaltaService faltaService;
    private final FaltaMapper faltaMapper;

    public FaltaController(FaltaService faltaService, FaltaMapper faltaMapper) {
        this.faltaService = faltaService;
        this.faltaMapper = faltaMapper;
    }

    @GetMapping
    public List<Falta> index() {
       return faltaService.findAll();
    }

    @GetMapping({ "/{id}" })
    public Falta index(@PathVariable int id) {
        return faltaService.findOne(id);
    }

    @GetMapping({ "/aluno/reprovado" })
    public boolean alunoReprovado(@RequestBody FaltaDTO falta) {
        return faltaService.alunoReprovaFalta(faltaMapper.converteDTOToAluno(falta));
    }

    @GetMapping({ "/aluno/calculoFaltas/{professor}/{cpf}" })
    public List<Falta> calculaFalta(@PathVariable String professor, @PathVariable String cpf) {
        return faltaService.calculaFalta(professor, cpf);
    }

    @PostMapping("/criaFalta/{professor}")
    public String criaFalta(@RequestBody FaltaDTO falta, @PathVariable String professor) {
        faltaService.criaFalta(faltaMapper.converteDTOToAluno(falta), professor);
        return "redirect:/falta";
    }

    @PostMapping("/criaPresenca/{professor}")
    public String criaPresenca(@RequestBody FaltaDTO falta, @PathVariable String professor) {
        faltaService.criaPresenca(faltaMapper.converteDTOToAluno(falta), professor);
        return "redirect:/falta";
    }

    @PutMapping("/edita/{professor}/{cpf}/{acheData}")
    public String editFalta(@PathVariable String professor,@PathVariable String cpf,@PathVariable LocalDate acheData) {
        faltaService.editaFalta(professor, cpf, acheData);
        return "redirect:/falta";
    }
}