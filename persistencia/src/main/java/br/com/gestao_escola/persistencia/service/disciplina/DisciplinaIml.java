package br.com.gestao_escola.persistencia.service.disciplina;

import br.com.gestao_escola.dominio.entidade.disciplina.Disciplina;
import br.com.gestao_escola.dominio.entidade.servico.DisciplinaService;
import br.com.gestao_escola.persistencia.converte.DisciplinaConverte;
import br.com.gestao_escola.persistencia.repositorio.DisciplinaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DisciplinaIml implements DisciplinaService {

    private final DisciplinaRepositorio disciplinaRepositorio;

    private final DisciplinaConverte disciplinaConverte;

    private DisciplinaValidaAbs disciplinaValidaAbs = new DisciplinaValidaAbs();

    public DisciplinaIml(DisciplinaRepositorio disciplinaRepositorio, DisciplinaConverte disciplinaConverte) {
        this.disciplinaRepositorio = disciplinaRepositorio;
        this.disciplinaConverte = disciplinaConverte;
    }

    @Override
    public void save(Disciplina disciplina) {
        disciplinaValidaAbs.criaDisciplina(disciplina);
        disciplinaRepositorio.save(disciplinaConverte.converteDisciplinaToEntidade(disciplina));
    }

    @Override
    public Disciplina findOne(int id) {
        return disciplinaConverte.converteEntitidadeToDisciplina(disciplinaRepositorio.findById(id).get());
    }

    @Override
    public Boolean exist(int id) {
        return disciplinaRepositorio.existsById(id);
    }

    @Override
    public List<Disciplina> listAll() {
        return disciplinaRepositorio.findAll()
                .stream()
                .map(disciplinaConverte::converteEntitidadeToDisciplina)
                .collect(Collectors.toList());
    }

    @Override
    public Disciplina edit(Disciplina disciplina) {
        Disciplina encontreDisciplina = findOne(disciplina.getId());

        if(disciplina.getAula() != null) encontreDisciplina.setAula(disciplina.getAula());
        if(disciplina.getProfessor() != null) encontreDisciplina.setProfessor(disciplina.getProfessor());
        if(disciplina.getTurma() != null) encontreDisciplina.setTurma(disciplina.getTurma());

        disciplinaValidaAbs.editaDisciplina(encontreDisciplina);
        disciplinaRepositorio.save(disciplinaConverte.converteDisciplinaToEntidade(disciplina));
        return encontreDisciplina;
    }

    @Override
    public void delete(int id) {
        Disciplina encontreDisciplina = findOne(id);
        disciplinaValidaAbs.deletaDisciplina(encontreDisciplina);
        disciplinaRepositorio.deleteById(id);
    }
}