package br.com.gestao_escola.controller;


import br.com.gestao_escola.entidade.servico.AlunoService;
import br.com.gestao_escola.model.AlunoDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/escola/aluno")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public String index() {
        return alunoService.listAll().toString();
    }

    @PostMapping("/create")
    public String createAluno(@RequestBody AlunoDTO alunoDTO) {
        alunoService.save(alunoDTO.converteDtoParaAluno());
        return "redirect:/aluno";
    }

    @PutMapping("/edit/{cpf}")
    public String editAluno(@RequestBody AlunoDTO alunoDTO, @PathVariable String cpf) {
        alunoService.edit(alunoDTO.converteDtoParaAluno(), cpf);
        return "redirect:/aluno";
    }
}
