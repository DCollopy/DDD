package br.com.gestao_escola.persistencia.service.falta;

import br.com.gestao_escola.dominio.entidade.aluno.Falta;
import br.com.gestao_escola.dominio.entidade.servico.FaltaService;
import br.com.gestao_escola.persistencia.converte.FaltaConverte;
import br.com.gestao_escola.persistencia.entidade.FaltaEntidade;
import br.com.gestao_escola.persistencia.repositorio.FaltaRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class FaltaIml implements FaltaService {
    private final FaltaRepositorio faltaRepositorio;
    private final FaltaConverte faltaConverte;
    private FaltaValidaAbs finalValidaAbs = new FaltaValidaAbs();

    public FaltaIml(FaltaRepositorio faltaRepositorio, FaltaConverte faltaConverte) {
        this.faltaRepositorio = faltaRepositorio;
        this.faltaConverte = faltaConverte;
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
    public Falta findOne(float id) {
        return faltaConverte.converteEntitidadeToFalta(faltaRepositorio.findById(id).get());
    }

    @Override
    public boolean alunoReprovaFalta(Falta falta) {
        FaltaEntidade faltaEntidade = faltaConverte.converteFaltaToEntidade(falta);
        Falta faltaAluno = faltaConverte.converteEntitidadeToFalta(faltaRepositorio
                .findFaltaEntidadeByAluno(faltaEntidade.getAluno().stream().iterator().next()));
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
        finalValidaAbs.editFalta(faltaList, professor,cpf, acheData);
    }

    @Override
    public List<Falta> findAll() {
        return faltaRepositorio.findAll().stream().map(faltaConverte::converteEntitidadeToFalta).toList();
    }
}