package br.com.gestao_escola.persistencia.service.aula;

import br.com.gestao_escola.dominio.entidade.aula.Aula;
import br.com.gestao_escola.dominio.entidade.servico.AulaService;
import br.com.gestao_escola.persistencia.converte.AulaConverte;
import br.com.gestao_escola.persistencia.entidade.AulaEntidade;
import br.com.gestao_escola.persistencia.repositorio.AulaRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AulaIml implements AulaService {

    private final AulaRepositorio aulaRepository;
    private final AulaConverte aulaConverte;

    private AulaValidaAbs aulaValidaAbs = new AulaValidaAbs();

    public AulaIml(AulaRepositorio aulaRepository, AulaConverte aulaConverte) {
        this.aulaRepository = aulaRepository;
        this.aulaConverte = aulaConverte;
    }

    @Override
    public void save(Aula aula) {
        aulaValidaAbs.criaAula(aula);
        aulaRepository.save(aulaConverte.converteAulaToEntidade(aula));
    }

    @Override
    public void edit(Aula aula) {
        Aula aulaEdit = findOne(aula.getId());

        if( aula.getNome() != null) aulaEdit.setNome(aula.getNome());
        if(aula.getDia_semana() != null) aulaEdit.setDia_semana(aula.getDia_semana());
        if(aula.getHora_inicio() != null) aulaEdit.setHora_inicio(aula.getHora_inicio());
        if(aula.getHora_fim() != null) aulaEdit.setHora_fim(aula.getHora_fim());

        Aula aulaParaEdicao = aulaValidaAbs.editaAula(aulaEdit);
        if (aulaParaEdicao != null) {
            aulaRepository.save(aulaConverte.converteAulaToEntidade(aulaParaEdicao));
        }
    }

    @Override
    public Aula findOne(int id) {
        return aulaConverte.converteEntitidadeToAula(aulaRepository.findById(id).orElse(null));
    }

    @Override
    public List<Aula> listAll() {
        return aulaRepository.findAll().stream().map(aulaConverte::converteEntitidadeToAula).toList();
    }

    @Override
    public void delete(int id) {
        Aula aulaExiste = aulaConverte.converteEntitidadeToAula(aulaRepository.findById(id).get());
        if (aulaExiste != null) {
            aulaRepository.deleteById(id);
            Logger.getLogger("Aula").info("Aula deletada com sucesso");
        }
    }
}