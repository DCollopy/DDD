package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.dominio.entidade.responsavel.Responsavel;
import br.com.gestao_escola.dominio.entidade.servico.AlunoService;
import br.com.gestao_escola.dominio.entidade.servico.ResponsavelService;
import br.com.gestao_escola.web.converte.AlunoMapper;
import br.com.gestao_escola.web.converte.CpfMapper;
import br.com.gestao_escola.web.converte.ResponsavelMapper;
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
    private final ResponsavelService responsavelService;

    private final ResponsavelMapper responsavelMapper;
    public AlunoController(AlunoService alunoService, AlunoMapper alunoMapper, CpfMapper cpfMapper, ResponsavelService responsavelService, ResponsavelMapper responsavelMapper) {
        this.alunoService = alunoService;
        this.alunoMapper = alunoMapper;
        this.cpfMapper = cpfMapper;
        this.responsavelService = responsavelService;
        this.responsavelMapper = responsavelMapper;
    }

    @GetMapping
    public List<Aluno> index() {
        return alunoService.listAll();
    }

    @GetMapping({ "/{cpf}" })
    public Aluno index(@PathVariable String cpf) {
        return alunoService.findOne(cpf);
    }

    @PostMapping("/criaAluno")
    public String createAluno(@RequestBody AlunoDTO alunoDTO) {
        Responsavel responsavel = responsavelService.findOne(cpfMapper.converteDTOToCpf(alunoDTO.getResponsavel().getCpf()));
        alunoDTO.setResponsavel(responsavelMapper.converteResponsavelToDTO(responsavel));
        alunoService.save(alunoMapper.converteDTOToAluno(alunoDTO));

        return "redirect:/aluno";
    }

    @PutMapping("/edita/{cpf}")
    public String editAluno(@RequestBody AlunoDTO alunoDTO) {
        alunoService.edit(alunoMapper.converteDTOToAluno(alunoDTO));
        return "redirect:/aluno";
    }

    @DeleteMapping("/deleta/{cpf}")
    public String deleteAluno(@PathVariable String cpf) {
        alunoService.delete(cpf);
        return "redirect:/aluno";
    }
}