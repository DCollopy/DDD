package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.aluno.Falta;
import br.com.gestao_escola.dominio.entidade.servico.AlunoService;
import br.com.gestao_escola.dominio.entidade.servico.AulaService;
import br.com.gestao_escola.dominio.entidade.servico.FaltaService;
import br.com.gestao_escola.web.converte.AlunoMapper;
import br.com.gestao_escola.web.converte.AulaMapper;
import br.com.gestao_escola.web.converte.FaltaMapper;
import br.com.gestao_escola.web.model.FaltaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/escola/falta")
public class FaltaController {
    private final FaltaService faltaService;
    private final FaltaMapper faltaMapper;
    private final AulaService aulaService;
    private final AlunoMapper alunoMapper;
    private final AlunoService alunoService;
    private final AulaMapper aulaMapper;

    public FaltaController(FaltaService faltaService, FaltaMapper faltaMapper, AulaService aulaService
            , AlunoMapper alunoMapper, AlunoService alunoService, AulaMapper aulaMapper) {
        this.faltaService = faltaService;
        this.faltaMapper = faltaMapper;
        this.aulaService = aulaService;
        this.alunoMapper = alunoMapper;
        this.alunoService = alunoService;
        this.aulaMapper = aulaMapper;
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
    public boolean alunoReprovado(@PathVariable String cpf) {
        alunoService.findOne(cpf);

        return faltaService.alunoReprovaFalta(alunoService.findOne(cpf));
    }

    @GetMapping({ "/aluno/calculoFaltas/{professor}/{cpf}" })
    public List<Falta> calculaFalta(@PathVariable String professor, @PathVariable String cpf) {
        return faltaService.calculaFalta(professor, cpf);
    }

    @PostMapping("/criaFalta/{professor}/{cpf}/{id}")
    public String criaFalta(@RequestBody FaltaDTO falta, @PathVariable String professor, @PathVariable String cpf, @PathVariable int id) {
        falta.setAluno(alunoMapper.converteAlunoToDTO(alunoService.findOne(cpf)));
        falta.setAula(aulaMapper.converteAulaToDTO(aulaService.findOne(id)));
        faltaService.criaFalta(faltaMapper.converteDTOToAluno(falta), professor);
        return "redirect:/falta";
    }

    @PostMapping("/criaPresenca/{professor}/{cpf}/{id}")
    public String criaPresenca(@RequestBody FaltaDTO falta, @PathVariable String professor, @PathVariable String cpf, @PathVariable int id) {
        falta.setAluno(alunoMapper.converteAlunoToDTO(alunoService.findOne(cpf)));
        falta.setAula(aulaMapper.converteAulaToDTO(aulaService.findOne(id)));
        faltaService.criaPresenca(faltaMapper.converteDTOToAluno(falta), professor);
        return "redirect:/falta";
    }

    @PutMapping("/edita/{professor}/{cpf}/{acheData}")
    public ResponseEntity<FaltaDTO> editFalta(@PathVariable String professor, @PathVariable String cpf, @PathVariable LocalDate acheData) {
        faltaService.editaFalta(professor, cpf, acheData);
        return ResponseEntity.ok().build();
    }
}