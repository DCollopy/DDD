package br.com.gestao_escola.persistencia.service.turma;


import br.com.gestao_escola.dominio.entidade.disciplina.Turma;
import br.com.gestao_escola.dominio.entidade.servico.TurmaService;
import br.com.gestao_escola.persistencia.converte.TurmaConverte;
import br.com.gestao_escola.persistencia.repositorio.TurmaRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TurmaIml implements TurmaService {

    private final TurmaRepositorio turmaRepositorio;

    private final TurmaConverte turmaConverte;

    private TurmaValidaAbs turmaValidaAbs = new TurmaValidaAbs();

    public TurmaIml(TurmaRepositorio turmaRepositorio, TurmaConverte turmaConverte) {
        this.turmaRepositorio = turmaRepositorio;
        this.turmaConverte = turmaConverte;
    }

    @Override
    public void save(Turma turma, String identidade) {
        turmaValidaAbs.criaTurma(turma, identidade);
        turmaRepositorio.save(turmaConverte.converteTurmaToEntidade(turma));
    }

    @Override
    public Turma edit(int id ,String identidade, Turma turmaEditada) {
        Turma turmaEncontre = findById(id);
        if(turmaEncontre == null) throw new IllegalArgumentException("Turma não encontrada");
        if(turmaEditada.getAluno() != null) turmaEncontre.setAluno(turmaEditada.getAluno());
        Turma turmaValida = turmaValidaAbs.editaTurma(turmaEditada, identidade);
        if (turmaValida != null) {
            turmaRepositorio.save(turmaConverte.converteTurmaToEntidade(turmaValida));
        }
        return turmaValida;
    }

    @Override
    public List<Turma> findAll() {
        return turmaRepositorio.findAll().stream().map(turmaConverte::converteEntidadeToTurma).toList();
    }

    @Override
    public Turma findById(int id) {
        return turmaConverte.converteEntidadeToTurma(turmaRepositorio.findById(id).orElse(null));
    }

    @Override
    public Boolean existsById(int id) {
        return turmaRepositorio.existsById(id);
    }

    @Override
    public void delete(Turma turma) {
        try {
            if (existsById(turma.getId())) {
                turmaRepositorio.delete(turmaConverte.converteTurmaToEntidade(turma));
                Logger.getLogger("Turma").info("Turma deletada com sucesso");
            }else {
                Logger.getLogger("Turma").info("Turma não encontrada");
            }
        } catch (Exception e) {
            Logger.getLogger("Turma").info("Erro ao deletar turma");
            throw new RuntimeException("Erro ao deletar turma");
        }
    }
}