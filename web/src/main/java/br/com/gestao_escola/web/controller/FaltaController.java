package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.aluno.Falta;
import br.com.gestao_escola.dominio.entidade.servico.FaltaService;
import br.com.gestao_escola.web.converte.FaltaMapper;
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
    public Falta index(@PathVariable Long id) {
        return faltaService.findOne(id);
    }

    @GetMapping({ "/aluno/reprovado" })
    public boolean alunoReprovado(@PathVariable Falta falta) {
        return faltaService.alunoReprovaFalta(falta);
    }

    @GetMapping({ "/aluno/calculoFaltas" })
    public List<Falta> calculaFalta(@PathVariable String professor, @PathVariable String cpf) {
        return faltaService.calculaFalta(professor, cpf);
    }

    @PostMapping("/cria/falta")
    public String criaFalta(@RequestBody Falta falta, @RequestBody String professor) {
        faltaService.criaFalta(falta, professor);
        return "redirect:/falta";
    }

    @PostMapping("/cria/presenca")
    public String criaPresenca(@RequestBody Falta falta, @RequestBody String professor) {
        faltaService.criaPresenca(falta, professor);
        return "redirect:/falta";
    }

    @PutMapping("/edit/{id}")
    public String editFalta(@RequestBody String professor, @RequestBody String cpf, @RequestBody LocalDate acheData) {
        faltaService.editaFalta(professor, cpf, acheData);
        return "redirect:/falta";
    }


}
