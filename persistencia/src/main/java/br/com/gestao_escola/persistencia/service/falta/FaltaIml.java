package br.com.gestao_escola.persistencia.service.falta;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.dominio.entidade.aluno.Falta;
import br.com.gestao_escola.dominio.entidade.servico.FaltaService;
import br.com.gestao_escola.persistencia.converte.AlunoConverte;
import br.com.gestao_escola.persistencia.converte.FaltaConverte;
import br.com.gestao_escola.persistencia.repositorio.FaltaRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FaltaIml implements FaltaService {
    private final FaltaRepositorio faltaRepositorio;
    private final FaltaConverte faltaConverte;

    private final AlunoConverte alunoConverter;
    private FaltaValidaAbs finalValidaAbs = new FaltaValidaAbs();

    public FaltaIml(FaltaRepositorio faltaRepositorio, FaltaConverte faltaConverte, AlunoConverte alunoConverter) {
        this.faltaRepositorio = faltaRepositorio;
        this.faltaConverte = faltaConverte;
        this.alunoConverter = alunoConverter;
    }

    @Override
    public void criaFalta(Falta falta, String professor) {
        finalValidaAbs.criaFalta(falta, professor);
        faltaRepositorio.save(faltaConverte.converteFaltaToEntidade(falta));
    }

    @Override
    public void criaPresenca(Falta falta, String professor) {
        finalValidaAbs.criaPresenca(falta, professor);
        faltaRepositorio.save(faltaConverte.converteFaltaToEntidade(falta));
    }

    @Override
    public Falta findOne(int id) {
        return faltaConverte.converteEntitidadeToFalta(faltaRepositorio.findById(id).get());
    }

    @Override
    public boolean alunoReprovaFalta(Aluno aluno) {
        Falta faltaAluno = faltaConverte.converteEntitidadeToFalta(faltaRepositorio
                .findFaltaEntidadeByAluno(alunoConverter.converteAlunoToEntidade(aluno)));
        return finalValidaAbs.alunoReprovaFalta(faltaAluno);
    }

    @Override
    public List<Falta> calculaFalta(String professor, String cpf) {
        List<Falta> faltaList = findAll();
        return finalValidaAbs.calculaFalta(faltaList, professor, cpf);
    }

    @Override
    public void editaFalta(String professor, String cpf, LocalDate acheData) {
        List<Falta> faltaList = findAll();
        Falta falta = finalValidaAbs.editFalta(faltaList, professor, cpf, acheData);
        if (falta != null) {
            faltaRepositorio.save(faltaConverte.converteFaltaToEntidade(falta));
        }
    }

    @Override
    public List<Falta> findAll() {
        return faltaRepositorio.findAll().stream().map(faltaConverte::converteEntitidadeToFalta).toList();
    }
}