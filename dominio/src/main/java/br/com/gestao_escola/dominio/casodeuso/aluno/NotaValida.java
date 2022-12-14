package br.com.gestao_escola.dominio.casodeuso.aluno;

import br.com.gestao_escola.dominio.entidade.aluno.Nota;

import java.util.List;
import java.util.logging.Logger;

public abstract class NotaValida {

    public Nota criaNota(Nota nota) {
        try {
            return new Nota(nota.getNota_1(), nota.getAula(), nota.getAluno());
        } catch (Exception e) {
            Logger.getLogger("Nota").info("Nota nao lançada");
            throw new IllegalArgumentException("Nota invalida");
        }
    }

    public Nota lancandoNotas(Nota nota) {
        if (nota.getNota_2() != 0) {
            if (nota.getNota_2() < 0 || nota.getNota_2() > 10) {
                Logger.getLogger("Nota").info("Nota invalido");
            }
            nota.setNota_2(nota.getNota_2());
        }
        if (nota.getNota_3() != 0) {
            if (nota.getNota_3() < 0 || nota.getNota_3() > 10) {
                Logger.getLogger("Nota").info("Nota não lançada");
            }
            nota.setNota_3(nota.getNota_3());
        }
        return nota;
    }

    public Nota mediaNota(Nota nota, String professor) {
        try {
            if (professor.equals("PROFESSOR")) {
                if (nota.getNota_2() != 0.0 || nota.getNota_3() != 0.0) {
                    nota.setMedia((nota.getNota_1() + nota.getNota_2()) / 2);
                    Logger.getLogger("Nota").info("Media Observaçao apenas duas notas lancadas: " + nota.getMedia());
                }
                if (nota.getNota_2() != 0.0 && nota.getNota_3() != 0.0) {
                    nota.setMedia((nota.getNota_1() + nota.getNota_2() + nota.getNota_3()) / 3);
                    Logger.getLogger("Nota").info("Media Observaçao apenas tres notas lancadas: " + nota.getMedia());
                }
            } else {
                Logger.getLogger("Nota").info("Apena professor pode lançar media");
            }
        } catch (Exception e) {
            Logger.getLogger("Nota").info("Nota não lançada");
            throw new IllegalArgumentException("Nota não lançada");
        }
        return nota;
    }
}