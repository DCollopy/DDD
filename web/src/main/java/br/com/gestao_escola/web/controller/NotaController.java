package br.com.gestao_escola.web.controller;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.dominio.entidade.aluno.Nota;
import br.com.gestao_escola.dominio.entidade.aula.Aula;
import br.com.gestao_escola.dominio.entidade.servico.AlunoService;
import br.com.gestao_escola.dominio.entidade.servico.AulaService;
import br.com.gestao_escola.dominio.entidade.servico.NotaService;
import br.com.gestao_escola.web.converte.AlunoMapper;
import br.com.gestao_escola.web.converte.AulaMapper;
import br.com.gestao_escola.web.converte.NotaMapper;
import br.com.gestao_escola.web.model.NotaDTO;
import br.com.gestao_escola.kafka.produtor.NotaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/escola/nota")
public class NotaController {
    private final NotaService notaService;
    private final NotaMapper notaMapper;
    private final NotaProducer notaProducer;
    private final AlunoService alunoService;
    private final AlunoMapper alunoMapper;
    private final AulaService aulaService;
    private final AulaMapper aulaMapper;

    public NotaController(NotaService notaService, NotaMapper notaMapper, NotaProducer notaProducer
            , AlunoService alunoService, AlunoMapper alunoMapper, AulaService aulaService, AulaMapper aulaMapper) {
        this.notaService = notaService;
        this.notaMapper = notaMapper;
        this.notaProducer = notaProducer;
        this.alunoService = alunoService;
        this.alunoMapper = alunoMapper;
        this.aulaService = aulaService;
        this.aulaMapper = aulaMapper;
    }

    @GetMapping("/calculoMedia/{id}/{professor}")
    public void mediaNota(@PathVariable int id, @PathVariable String professor) {
        notaService.mediaNota(id, professor);
    }

    @GetMapping("/mediaAluno/{id}/{cpf}")
    public ResponseEntity<Double> mediaAluno(@PathVariable int id, @PathVariable String cpf) {
        return ResponseEntity.ok(notaService.buscaMedia(id, cpf));
    }

    @PostMapping("/criaNota/{cpf}/{id}")
    public ResponseEntity<NotaDTO> criaNota(@RequestBody NotaDTO nota, @PathVariable String cpf, @PathVariable int id) throws InterruptedException {
        Aluno aluno = alunoService.findOne(cpf);
        Aula aula = aulaService.findOne(id);
        if (aula != null && aluno != null) {
            nota.setAluno(alunoMapper.converteAlunoToDTO(aluno));
            nota.setAula(aulaMapper.converteAulaToDTO(aula));
            notaProducer.send(notaMapper.converteNotaToDTOProducer(nota));
            notaService.criaNota(notaMapper.converteDTOToNota(nota));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/lancandoNotas/{cpf}/{id}")
    public ResponseEntity<NotaDTO> lancandoNotas(@PathVariable int id) throws InterruptedException {
        Nota nota = notaService.encontreNota(id);
        notaService.lancandoNotas(nota);
        return ResponseEntity.badRequest().build();
    }
}