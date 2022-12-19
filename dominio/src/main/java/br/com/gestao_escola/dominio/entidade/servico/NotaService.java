package br.com.gestao_escola.dominio.entidade.servico;

import br.com.gestao_escola.dominio.entidade.aluno.Nota;

import java.util.List;

public interface NotaService {

    void criaNota(Nota nota);

    void mediaNota(String cpf, float id, String professor);

    double buscaMedia(float id,String cpf);
}