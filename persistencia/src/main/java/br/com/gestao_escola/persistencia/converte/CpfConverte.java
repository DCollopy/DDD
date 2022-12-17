package br.com.gestao_escola.persistencia.converte;

import br.com.gestao_escola.dominio.entidade.objetos.Cpf;
import br.com.gestao_escola.persistencia.entidade.CpfEntidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CpfConverte {

    private final ModelMapper modelMapper;

    public Cpf converteEntidadeToCpf(CpfEntidade cpfEntidade) {
        return modelMapper.map(cpfEntidade, Cpf.class);
    }

    public CpfEntidade converteCpfToEntidade(Cpf cpf) {
        CpfEntidade cpfConvert = modelMapper.map(cpf, CpfEntidade.class);
        return cpfConvert;
    }
}
