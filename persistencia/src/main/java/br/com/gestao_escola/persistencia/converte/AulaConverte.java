package br.com.gestao_escola.persistencia.converte;

import br.com.gestao_escola.dominio.entidade.aula.Aula;
import br.com.gestao_escola.persistencia.entidade.AulaEntidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AulaConverte {
    private final ModelMapper modelMapper;

    public Aula converteEntitidadeToAula(AulaEntidade aulaEntidade) {
        return modelMapper.map(aulaEntidade, Aula.class);
    }

    public AulaEntidade converteAulaToEntidade(Aula aula) {
        return modelMapper.map(aula, AulaEntidade.class);
    }
}