package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.servico.AulaService;
import br.com.gestao_escola.web.converte.AulaMapper;
import br.com.gestao_escola.web.model.AulaDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/escola/aula")
public class AulaController {
    private final AulaService aulaService;
    private final AulaMapper aulaMapper;

    public AulaController(AulaService aulaService, AulaMapper aulaMapper) {
        this.aulaService = aulaService;
        this.aulaMapper = aulaMapper;
    }

    @GetMapping
    public void index() {
        aulaService.listAll();
    }

    @GetMapping({ "/{id}" })
    public void index(@PathVariable Float id) {
        aulaService.findOne(id);
    }

    @PostMapping("/criaAula")
    public void createAula(AulaDTO aulaDTO) {
        aulaService.save(aulaMapper.converteDTOToAula(aulaDTO));
    }

    @PutMapping("/edita/{id}")
    public void editAula(AulaDTO aulaDTO) {
        aulaService.edit(aulaMapper.converteDTOToAula(aulaDTO));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAula(@PathVariable Long id) {
        aulaService.delete(id);
    }
}