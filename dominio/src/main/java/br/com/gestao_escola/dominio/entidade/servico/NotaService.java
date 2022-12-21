package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.aluno.Nota;

import java.util.List;

public interface NotaService {

    void criaNota(Nota nota);
    void lancandoNotas(Nota nota);
    void mediaNota(int id, String professor);

    double buscaMedia(int id);

    Nota encontreNota(int id);
}