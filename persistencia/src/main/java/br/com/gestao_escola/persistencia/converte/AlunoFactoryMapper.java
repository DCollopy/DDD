package br.com.gestao_escola.persistencia.converte;

import org.mapstruct.factory.Mappers;

public class AlunoFactoryMapper {

    private AlunoFactoryMapper() {
    }

    public static Object factory(final Class clazz){
        return Mappers.getMapper(clazz);
    }
}
