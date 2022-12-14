package br.com.gestao_escola.dominio.casodeuso.aula;

import br.com.gestao_escola.dominio.entidade.aula.Aula;
import java.util.logging.Logger;

public abstract class AulaValida {

    public void validaAula(Aula aula) {
        if(aula.getNome() == null || aula.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome da aula não pode ser vazio");
        }
        if(aula.getDescricao() == null || aula.getDescricao().isEmpty()) {
            throw new IllegalArgumentException("Descrição da aula não pode ser vazia");
        }
        if(aula.getData_inicio() == null) {
            throw new IllegalArgumentException("Data de início da aula não pode ser vazia");
        }
        if(aula.getData_fim() == null) {
            throw new IllegalArgumentException("Data de fim da aula não pode ser vazia");
        }
        if(aula.getHora_inicio() == null) {
            throw new IllegalArgumentException("Hora de início da aula não pode ser vazia");
        }
        if(aula.getHora_fim() == null) {
            throw new IllegalArgumentException("Hora de fim da aula não pode ser vazia");
        }
        if(aula.getDia_semana() == null || aula.getDia_semana().isEmpty()) {
            throw new IllegalArgumentException("Dia da semana da aula não pode ser vazio");
        }
        if(aula.getData_inicio().isAfter(aula.getData_fim())) {
            throw new IllegalArgumentException("Data de início da aula não pode ser maior que a data de fim");
        }
        if(aula.getHora_inicio().isAfter(aula.getHora_fim())) {
            throw new IllegalArgumentException("Hora de início da aula não pode ser maior que a hora de fim");
        }
    }

    public Aula criaAula(Aula aula) {
        try {
            validaAula(aula);
            Logger.getLogger("Aula").info("Aula criada com sucesso");
            return new Aula(aula.getNome(), aula.getDescricao(), aula.getData_inicio(), aula.getData_fim()
                    , aula.getHora_inicio(), aula.getHora_fim(), aula.getDia_semana(), aula.getDia_semana_2()
                    , aula.getDia_semana_3(), aula.getAulaAtiva());
        } catch (IllegalArgumentException e) {
            Logger.getLogger("Aula").info("Aula não criada");
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Aula editaAula(Aula aula) {
        try {
            validaAula(aula);
            Logger.getLogger("Aula").info("Aula editada com sucesso");
            return new Aula(aula.getNome(), aula.getDescricao(), aula.getData_inicio(), aula.getData_fim()
                    , aula.getHora_inicio(), aula.getHora_fim(), aula.getDia_semana(), aula.getDia_semana_2()
                    , aula.getDia_semana_3(), aula.getAulaAtiva());
        } catch (IllegalArgumentException e) {
            Logger.getLogger("Aula").info("Aula não editada");
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}