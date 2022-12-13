package br.com.gestao_escola.service.aluno;

import br.com.gestao_escola.converte.AlunoMapper;
import br.com.gestao_escola.entidade.aluno.Aluno;
import br.com.gestao_escola.entidade.servico.AlunoService;
import br.com.gestao_escola.repositorio.AlunoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceIml implements AlunoService {
    private final AlunoRepositorio alunoRepositorio;
    private final AlunoValidaAbs alunoValidaAbs;

    private final AlunoMapper alunoMapper;

    public AlunoServiceIml(AlunoRepositorio alunoRepositorio, AlunoValidaAbs alunoValidaAbs, AlunoMapper alunoMapper) {
        this.alunoRepositorio = alunoRepositorio;
        this.alunoValidaAbs = alunoValidaAbs;
        this.alunoMapper = alunoMapper;
    }

    @Override
    public void save(Aluno aluno) {


    }

    @Override
    public Aluno findOne(String cpf) {
        return null;
    }

    @Override
    public Boolean exist(String cpf) {
        return null;
    }

    @Override
    public Aluno edit(Aluno aluno, String cpf) {
        return null;
    }

    @Override
    public void delete(String cpf) {

    }

    @Override
    public List<Aluno> listAll() {
        return null;
    }
}
