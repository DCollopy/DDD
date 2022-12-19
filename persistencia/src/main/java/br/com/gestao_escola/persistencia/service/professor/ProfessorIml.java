package br.com.gestao_escola.persistencia.service.professor;

import br.com.gestao_escola.dominio.entidade.objetos.Cpf;
import br.com.gestao_escola.dominio.entidade.professor.Professor;
import br.com.gestao_escola.dominio.entidade.servico.ProfessorService;
import br.com.gestao_escola.persistencia.converte.CpfConverte;
import br.com.gestao_escola.persistencia.converte.ProfessorConverte;
import br.com.gestao_escola.persistencia.repositorio.ProfessorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorIml implements ProfessorService {
    private final ProfessorRepositorio professorRepositorio;
    private final ProfessorValidaAbs professorValidaAbs = new ProfessorValidaAbs();
    private final ProfessorConverte professorConverte;
    private final CpfConverte cpfConverte;

    public ProfessorIml(ProfessorRepositorio professorRepositorio, ProfessorConverte professorConverte, CpfConverte cpfConverte) {
        this.professorRepositorio = professorRepositorio;
        this.professorConverte = professorConverte;
        this.cpfConverte = cpfConverte;
    }

    @Override
    public void save(Professor professor) {
        professorValidaAbs.criaProfessor(professor);
        professorRepositorio.save(professorConverte.converteProfessorToEntidade(professor));
    }

    @Override
    public Professor findOne(String cpf) {
        Cpf cpf1 = new Cpf(cpf);
        return professorConverte
                .converteEntitidadeToProfessor(professorRepositorio.findById(cpfConverte.converteCpfToEntidade(cpf1)).get());
    }

    @Override
    public Boolean exist(String cpf) {
        return professorRepositorio.existsById(cpfConverte.converteCpfToEntidade(new Cpf(cpf)));
    }

    @Override
    public Professor edit(Professor professor) {
        Professor professorEdit = findOne(professor.getCpf().getCpf());
        Professor professorParaEdicao = professorValidaAbs.editaProfessor(professorEdit);
        if (professorParaEdicao != null) {
            professorRepositorio.save(professorConverte.converteProfessorToEntidade(professorParaEdicao));
        }
        return professorParaEdicao;
    }

    @Override
    public void delete(String cpf) {
        Professor professorExiste = findOne(cpf);
        if (professorExiste != null) {
            professorRepositorio.deleteById(cpfConverte.converteCpfToEntidade(new Cpf(cpf)));
        }
    }

    @Override
    public List<Professor> listAll() {
        return professorRepositorio.findAll().stream()
                .map(professorConverte::converteEntitidadeToProfessor)
                .toList();
    }
}