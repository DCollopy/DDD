package br.com.gestao_escola.persistencia.service.aluno;

import br.com.gestao_escola.persistencia.converte.AlunoMapper;
import br.com.gestao_escola.dominio.entidade.aluno.Aluno;
import br.com.gestao_escola.dominio.entidade.servico.AlunoService;
import br.com.gestao_escola.persistencia.repositorio.AlunoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceIml implements AlunoService {
    private final AlunoRepositorio alunoRepositorio;
    private final AlunoValidaAbs alunoValidaAbs = new AlunoValidaAbs();
    private final AlunoMapper alunoMapper;

    public AlunoServiceIml(AlunoRepositorio alunoRepositorio, AlunoMapper alunoMapper) {
        this.alunoRepositorio = alunoRepositorio;
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
