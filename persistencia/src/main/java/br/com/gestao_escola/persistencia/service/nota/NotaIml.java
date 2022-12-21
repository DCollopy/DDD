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
    public void lancandoNotas(Nota nota) {
        if(nota.getNota_2() == 0 && nota.getNota_3() == 0){
            throw new IllegalArgumentException("Nota não lançada");
        }
        Nota nota_validado = notaValidaAbs.lancandoNotas(nota);
        notaRepositorio.save(notaConverte.converteNotaToEntidade(nota_validado));
    }

    @Override
    public void mediaNota(int id, String professor) {
        Nota nota = encontreNota(id);
        notaValidaAbs.mediaNota(nota, professor);
        notaRepositorio.save(notaConverte.converteNotaToEntidade(nota));
    }
    @Override
    public double buscaMedia(int id, String cpf) {
        List<NotaEntidade> nota = notaRepositorio.findAll();
        return nota.stream()
                .filter(notaEntidade -> notaEntidade.getAula().getId() == id && notaEntidade.getAluno().getCpf().getCpf().contains(cpf))
                .mapToDouble(NotaEntidade::getMedia)
                .iterator().next();
    }

    @Override
    public Nota encontreNota(int id) {
        return notaConverte.converteEntidadeToNota(notaRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Nota não encontrada")));
    }
}