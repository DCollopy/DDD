package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.dominio.entidade.servico.AlunoService;
import br.com.gestao_escola.web.converte.AlunoMapper;
import br.com.gestao_escola.web.converte.CpfMapper;
import br.com.gestao_escola.web.model.AlunoDTO;
import br.com.gestao_escola.web.model.CpfDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escola/aluno")
public class AlunoController {
    private final AlunoService alunoService;
    private final AlunoMapper alunoMapper;

    private final CpfMapper cpfMapper;
    public AlunoController(AlunoService alunoService, AlunoMapper alunoMapper, CpfMapper cpfMapper) {
        this.alunoService = alunoService;
        this.alunoMapper = alunoMapper;
        this.cpfMapper = cpfMapper;
    }

    @GetMapping
    public List<Aluno> index() {
        return alunoService.listAll();
    }

    @GetMapping({ "/{cpf}" })
    public Aluno index(@PathVariable CpfDTO cpf) {
        return alunoService.findOne(cpfMapper.converteDTOToCpf(cpf));
    }

    @PostMapping("/create")
    public String createAluno(@RequestBody AlunoDTO alunoDTO) {
        alunoService.save(alunoMapper.converteDTOToAluno(alunoDTO));
        return "redirect:/aluno";
    }

    @PutMapping("/edit/{cpf}")
    public String editAluno(@RequestBody AlunoDTO alunoDTO) {
        alunoService.edit(alunoMapper.converteDTOToAluno(alunoDTO));
        return "redirect:/aluno";
    }
}