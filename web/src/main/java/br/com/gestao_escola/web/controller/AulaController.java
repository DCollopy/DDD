package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.aula.Aula;
import br.com.gestao_escola.dominio.entidade.servico.AulaService;
import br.com.gestao_escola.web.converte.AulaMapper;
import br.com.gestao_escola.web.model.AulaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Aula> index() {
        return aulaService.listAll();
    }

    @GetMapping({ "/{id}" })
    public Aula index(@PathVariable int id) {
        return aulaService.findOne(id);
    }

    @PostMapping("/criaAula")
    public void createAula(@RequestBody AulaDTO aulaDTO) {
        aulaService.save(aulaMapper.converteDTOToAula(aulaDTO));
    }

    @PutMapping("/edita/{id}")
    public void editAula(@RequestBody AulaDTO aulaDTO) {
        aulaService.edit(aulaMapper.converteDTOToAula(aulaDTO));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAula(@PathVariable int id) {
        aulaService.delete(id);
    }
}