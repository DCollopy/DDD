package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.servico.NotaService;
import br.com.gestao_escola.web.converte.NotaMapper;
import br.com.gestao_escola.web.model.NotaDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/escola/nota")
public class NotaController {

    private final NotaService notaService;

    private final NotaMapper notaMapper;

    public NotaController(NotaService notaService, NotaMapper notaMapper) {
        this.notaService = notaService;
        this.notaMapper = notaMapper;
    }

    @GetMapping("/calculoMedia")
    public void mediaNota(@PathVariable String cpf, @PathVariable float id, @PathVariable String professor) {
        notaService.mediaNota(cpf, id, professor);
    }

    @GetMapping("/mediaAluno")
    public void mediaAluno(@PathVariable float id, @PathVariable String cpf) {
        notaService.buscaMedia(id,cpf);
    }

    @PostMapping("/criaNota")
    public void criaNota(@RequestBody NotaDTO nota) {
        notaService.criaNota(notaMapper.converteDTOToNota(nota));
    }
}