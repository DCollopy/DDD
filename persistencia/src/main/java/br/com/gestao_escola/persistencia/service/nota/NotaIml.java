package br.com.gestao_escola.persistencia.service.nota;

import br.com.gestao_escola.dominio.entidade.aluno.Nota;
import br.com.gestao_escola.dominio.entidade.servico.NotaService;
import br.com.gestao_escola.persistencia.converte.NotaConverte;
import br.com.gestao_escola.persistencia.entidade.NotaEntidade;
import br.com.gestao_escola.persistencia.repositorio.NotaRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotaIml implements NotaService {
    private final NotaConverte notaConverte;

    private final NotaRepositorio notaRepositorio;

    private NotaValidaAbs notaValidaAbs = new NotaValidaAbs();

    public NotaIml(NotaConverte notaConverte, NotaRepositorio notaRepositorio) {
        this.notaConverte = notaConverte;
        this.notaRepositorio = notaRepositorio;
    }

    @Override
    public void criaNota(Nota nota) {
        notaValidaAbs.criaNota(nota);
        notaRepositorio.save(notaConverte.converteNotaToEntidade(nota));
    }
    @Override
    public void mediaNota(String cpf, int id, String professor) {
        List<NotaEntidade> notaEntidade = notaRepositorio.findAll();
        List<Nota> nota = notaEntidade.stream().map(notaConverte::converteEntidadeToNota).collect(Collectors.toList());
        notaValidaAbs.mediaNota(nota, cpf, id, professor);
        notaRepositorio.save(notaConverte.converteNotaToEntidade(nota.get(0)));
    }
    @Override
    public double buscaMedia(int id, String cpf) {
        List<NotaEntidade> nota = notaRepositorio.findAll();
        return nota.stream()
                .filter(notaEntidade -> notaEntidade.getAula().getId() == id && notaEntidade.getAluno().getCpf().getCpf().contains(cpf))
                .mapToDouble(NotaEntidade::getMedia)
                .iterator().next();
    }
}