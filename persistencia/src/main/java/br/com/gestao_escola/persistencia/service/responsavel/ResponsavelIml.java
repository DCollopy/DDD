package br.com.gestao_escola.persistencia.service.responsavel;

import br.com.gestao_escola.dominio.entidade.objetos.Cpf;
import br.com.gestao_escola.dominio.entidade.responsavel.Responsavel;
import br.com.gestao_escola.dominio.entidade.servico.ResponsavelService;
import br.com.gestao_escola.persistencia.converte.CpfConverte;
import br.com.gestao_escola.persistencia.converte.ResponsavelConverte;
import br.com.gestao_escola.persistencia.entidade.ResponsavelEntidade;
import br.com.gestao_escola.persistencia.repositorio.ResponsavelRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ResponsavelIml implements ResponsavelService {
    private final ResponsavelRepositorio responsavelRepositorio;
    private ResponsavelAbs responsavelAbs = new ResponsavelAbs();
    private final ResponsavelConverte responsavelConverte;
    private final CpfConverte cpfConverte;

    public ResponsavelIml(ResponsavelRepositorio responsavelRepository, ResponsavelConverte responsavelConverte, CpfConverte cpfConverte) {
        this.responsavelRepositorio = responsavelRepository;
        this.responsavelConverte = responsavelConverte;
        this.cpfConverte = cpfConverte;
    }

    @Override
    public void save(Responsavel responsavel) {
        responsavelAbs.criaResponsavel(responsavel);
        responsavelRepositorio.save(responsavelConverte.converteResponsavelToEntidade(responsavel));
    }

    @Override
    public Responsavel edit(Responsavel responsavel) {
        return null;
    }

    @Override
    public Responsavel findOne(Cpf cpf) {
        ResponsavelEntidade responsavelExiste = responsavelRepositorio.findOnesByCpf(cpfConverte.converteCpfToEntidade(cpf));
        return responsavelConverte.converteEntidadeToResponsavel(responsavelExiste);
    }

    @Override
    public Boolean exist(Cpf cpf) {
        return responsavelRepositorio.existsById(cpfConverte.converteCpfToEntidade(cpf));
    }

    @Override
    public List<Responsavel> listAll() {
        return responsavelRepositorio.findAll().stream().map(responsavelConverte::converteEntidadeToResponsavel).collect(Collectors.toList());
    }

    @Override
    public void delete(Cpf cpf) {
        Responsavel responsavelExiste = findOne(cpf);
        if(responsavelExiste != null){
            Logger.getLogger("Responsavel").info("Responsavel deletado com sucesso" + responsavelExiste.getNome());
            responsavelRepositorio.delete(responsavelConverte.converteResponsavelToEntidade(responsavelExiste));
        } else {
            Logger.getLogger("Responsavel").info("Responsavel não encontrado");
            throw new RuntimeException("Responsavel não encontrado");
        }
    }
}