package br.com.gestao_escola.dominio.casodeuso.aluno;

import br.com.gestao_escola.dominio.entidade.aluno.Nota;

import java.util.List;
import java.util.logging.Logger;

public abstract class NotaValida {

    public Nota criaNota(Nota nota) {
        try {
            return new Nota (nota.getNota(), nota.getAula(), nota.getAluno());
        } catch (Exception e) {
            Logger.getLogger("Nota").info("Nota nao lançada");
            throw new IllegalArgumentException("Nota invalida");
        }
    }


    public List<Nota> mediaNota(List<Nota> nota, String cpf, float id, String professor) {
        if (professor.equals("PROFESSOR")) {
            nota.stream()
                    .filter(n -> n.getAluno().getCpf().getCpf().contains(cpf) && n.getId() == id)
                    .mapToDouble(Nota::getNota).average()
                    .ifPresent(n -> nota.get(0).setMedia(n));
        } else {
            Logger.getLogger("Nota").info("Media nao calculada");
            throw new IllegalArgumentException("Ops, algo deu errado!");
        }
        return nota;
    }
}
