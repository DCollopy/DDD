package br.com.gestao_escola.persistencia.service.aluno;

import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.dominio.entidade.objetos.Cpf;
import br.com.gestao_escola.dominio.entidade.servico.AlunoService;
import br.com.gestao_escola.persistencia.converte.AlunoConverte;
import br.com.gestao_escola.persistencia.converte.CpfConverte;
import br.com.gestao_escola.persistencia.entidade.AlunoEntidade;
import br.com.gestao_escola.persistencia.repositorio.AlunoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class AlunoServiceIml implements AlunoService {
    private final AlunoRepositorio alunoRepositorio;
    private final AlunoValidaAbs alunoValidaAbs = new AlunoValidaAbs();
    private final AlunoConverte alunoConverte;

    private final CpfConverte cpfConvertes;

    public AlunoServiceIml(AlunoRepositorio alunoRepositorio, AlunoConverte alunoConverte, CpfConverte cpfConvertes) {
        this.alunoRepositorio = alunoRepositorio;
        this.alunoConverte = alunoConverte;
        this.cpfConvertes = cpfConvertes;
    }

    @Override
    public void save(Aluno aluno) {
        alunoValidaAbs.criaAluno(aluno);
        alunoRepositorio.save(alunoConverte.converteAlunoToEntidade(aluno));
    }

    @Override
    public Aluno findOne(String cpf) {
        AlunoEntidade encontreUmAluno = alunoRepositorio.findOnesByCpf(cpfConvertes.converteCpfToEntidade(new Cpf(cpf)));
        return alunoConverte.converteEntitidadeToAluno(encontreUmAluno);
    }

    @Override
    public Boolean exist(Aluno aluno) {
        return alunoRepositorio.existsById(cpfConvertes.converteCpfToEntidade(aluno.getCpf()));
    }

    @Override
    public void edit(Aluno aluno) {
        Aluno alunoEditado = findOne(aluno.getCpf().getCpf());
        if (alunoEditado != null) {
            Aluno editAluno = alunoValidaAbs.editAluno(alunoEditado);
            alunoRepositorio.save(alunoConverte.converteAlunoToEntidade(editAluno));
            Logger.getLogger("Aluno").info("Aluno editado com sucesso" + editAluno.getNome());
        }
        Logger.getLogger("Aluno").info("Aluno nao encontrado" + alunoEditado.getNome());
    }

    @Override
    public void delete(String cpf) {
        AlunoEntidade encontreUmAluno = alunoRepositorio.findOnesByCpf(cpfConvertes.converteCpfToEntidade(new Cpf(cpf)));
        if (encontreUmAluno != null) {
            alunoRepositorio.delete(encontreUmAluno);
            Logger.getLogger("Aluno").info("Aluno deletado com sucesso" + encontreUmAluno.getNome());
        } else {
            Logger.getLogger("Aluno").info("Aluno não existe");
        }
    }

    @Override
    public List<Aluno> listAll() {
        return alunoRepositorio.findAll().stream().map(alunoConverte::converteEntitidadeToAluno).collect(Collectors.toList());
    }
}