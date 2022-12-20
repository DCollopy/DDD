package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.responsavel.Responsavel;
import br.com.gestao_escola.dominio.entidade.servico.ResponsavelService;
import br.com.gestao_escola.web.converte.CpfMapper;
import br.com.gestao_escola.web.converte.ResponsavelMapper;
import br.com.gestao_escola.web.model.CpfDTO;
import br.com.gestao_escola.web.model.ResponsavelDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escola/responsavel")
public class ResponsavelContoller {
    private final ResponsavelService responsavelService;
    private final ResponsavelMapper responsavelMapper;

    public ResponsavelContoller(ResponsavelService responsavelService, ResponsavelMapper responsavelMapper) {
        this.responsavelService = responsavelService;
        this.responsavelMapper = responsavelMapper;
    }

    @GetMapping
    public List<Responsavel> index() {
        return responsavelService.listAll();
    }

    @GetMapping({ "/{cpf}" })
    public Responsavel index(@PathVariable String cpf) {
        return responsavelService.findOne(cpf);
    }

    @PostMapping("/criaResponsavel")
    public String createResponsavel(@RequestBody ResponsavelDTO responsavelDTO) {
        responsavelService.save(responsavelMapper.converteDTOToResponsavel(responsavelDTO));
        return "redirect:/responsavel";
    }

    @PutMapping("/edita/{cpf}")
    public String editResponsavel(@PathVariable String cpf) {
        responsavelService.edit(responsavelService.findOne(cpf));
        return "redirect:/responsavel";
    }
}
