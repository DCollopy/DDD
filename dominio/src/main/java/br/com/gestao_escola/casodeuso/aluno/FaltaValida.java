package br.com.gestao_escola.casodeuso.aluno;

import br.com.gestao_escola.entidade.aluno.Falta;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public abstract class FaltaValida {

    public Falta criaFalta(Falta falta, String professor) {
        try {
            if (professor.equals("PROFESSOR")) {
                Logger.getLogger("Falta").info("Falta criada com sucesso");
                return new Falta(falta.getAluno(), falta.getAula(), falta.getJustificativa());
            }
        } catch (Exception e) {
            Logger.getLogger("Falta").info("Falta nao lançada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
        return falta;
    }

    public Falta criaPresenca(Falta falta, String professor) {
        try {
            if (professor.equals("PROFESSOR")) {
                Logger.getLogger("Falta").info("Presenca criada com sucesso");
                return new Falta(falta.getAluno(), falta.getAula());
            }
        } catch (Exception e) {
            Logger.getLogger("Falta").info("Presença nao lançada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
        return falta;
    }

    public void editFalta(List<Falta> falta, String professor, String cpf, LocalDate acheData) {
        try {
            if (professor.equals("PROFESSOR") && falta.stream().anyMatch(c -> c.getAluno().getCpf().getNumero().contains(cpf))) {

                falta.stream().filter(f -> f.getFalta_data() == acheData && f.getNumeroFaltas() == 1).forEach(f -> {
                    f.setNumeroFaltas(f.getNumeroFaltas() - 1);
                    f.setNumeroPresenca(f.getNumeroPresenca() + 1);
                    f.setPresenca(acheData);
                    f.setFalta_data(null);
                    f.setJustificativa("Falta justificada");
                    Logger.getLogger("Falta").info("Falta editada com sucesso");
                });
            }
        } catch (Exception e) {
            Logger.getLogger("Falta").info("Presenca nao calculada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }

    public boolean calculaFalta(List<Falta> falta, String professor, String cpf) {
        try {
            setFaltas(falta, professor, cpf);
            Logger.getLogger("Falta").info("Presenca calculada com sucesso");
            return true;
        } catch (Exception e) {
            Logger.getLogger("Falta").info("Presenca nao calculada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
    }

    public boolean alunoReprovaFalta(Falta falta, String cpf) {
        try {
            if (falta.getAluno().getCpf().getNumero().contains(cpf) && falta.getAula().getStatus()) {
                int total = (falta.getTotalFaltas() + falta.getTotalPreenca());
                double aulas = total * 0.8;
                Logger.getLogger("Falta").info("Falta do aluno calculada com sucesso");
                return falta.getTotalPreenca() >= aulas;
            }
        } catch (Exception e) {
            Logger.getLogger("Falta").info("Falta do aluno nao calculada");
            throw new IllegalArgumentException("Ops, algo deu errado");
        }
        return false;
    }

    public void setFaltas(List<Falta> falta, String professor, String cpf) {
        int totalPresenca;
        int totalFalta;
        if (professor.equals("PROFESSOR") && falta.stream()
                .filter(f -> f.getAula().getStatus())
                .anyMatch(f -> f.getAluno().getCpf().getNumero().contains(cpf))) {

            totalPresenca = falta.stream()
                    .filter(f -> f.getAluno().getCpf().getNumero().contains(cpf))
                    .mapToInt(Falta::getNumeroPresenca).sum();
            totalFalta = falta.stream()
                    .filter(f -> f.getAluno().getCpf().getNumero().contains(cpf))
                    .mapToInt(Falta::getNumeroFaltas).sum();
            falta.stream()
                    .filter(f -> f.getAluno().getCpf().getNumero().contains(cpf)).forEach(f -> {
                        f.setTotalFaltas(totalFalta);
                        f.setTotalPreenca(totalPresenca);
                    });
        }
    }
}
