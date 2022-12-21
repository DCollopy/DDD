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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/escola/nota")
public class NotaController {
    private final NotaService notaService;
    private final NotaMapper notaMapper;

    private final AlunoService alunoService;
    private final AlunoMapper alunoMapper;
    private final AulaService aulaService;
    private final AulaMapper aulaMapper;

    public NotaController(NotaService notaService, NotaMapper notaMapper, AlunoService alunoService
            , AlunoMapper alunoMapper, AulaService aulaService, AulaMapper aulaMapper) {
        this.notaService = notaService;
        this.notaMapper = notaMapper;
        this.alunoService = alunoService;
        this.alunoMapper = alunoMapper;
        this.aulaService = aulaService;
        this.aulaMapper = aulaMapper;
    }

    @GetMapping("/calculoMedia/{id}/{professor}")
    public void mediaNota(@PathVariable int id, @PathVariable String professor) {
        notaService.mediaNota(id, professor);
    }

    @GetMapping("/mediaAluno/{id}")
    public ResponseEntity<Double> mediaAluno(@PathVariable int id) {
        return ResponseEntity.ok(notaService.buscaMedia(id));
    }

    @PostMapping("/criaNota/{cpf}/{id}")
    public ResponseEntity<NotaDTO> criaNota(@RequestBody NotaDTO nota
            , @PathVariable String cpf
            , @PathVariable int id) throws InterruptedException {
        Aluno aluno = alunoService.findOne(cpf);
        Aula aula = aulaService.findOne(id);
        if (aula != null && aluno != null) {
            nota.setAluno(alunoMapper.converteAlunoToDTO(aluno));
            notaService.criaNota(notaMapper.converteDTOToNota(nota));
            TimeUnit.SECONDS.sleep(1);
            nota.setAula(aulaMapper.converteAulaToDTO(aula));
            notaService.criaNota(notaMapper.converteDTOToNota(nota));
        }
        return ResponseEntity.ok(nota);
    }

    @PutMapping("/lancandoNotas/{id}")
    public ResponseEntity<NotaDTO> lancandoNotas(@PathVariable int id
            ,@RequestParam (value = "nota_2", required = false ) double nota_2
            ,@RequestParam (value = "nota_3", required = false )  double nota_3) throws InterruptedException {
        Nota nota = notaService.encontreNota(id);
        if(nota_2 != 0){
            nota.setNota_2(nota_2);
            nota.setMedia(0);
        }
        if(nota_3 != 0){
            nota.setNota_3(nota_3);
            nota.setMedia(0);
        }
        notaService.lancandoNotas(nota);
        return ResponseEntity.ok(notaMapper.converteNotaToDTO(nota));
    }
}