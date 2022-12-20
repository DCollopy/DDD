package br.com.gestao_escola.persistencia.repositorio;

import br.com.gestao_escola.persistencia.entidade.AlunoEntidade;
import br.com.gestao_escola.persistencia.entidade.FaltaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FaltaRepositorio extends JpaRepository<FaltaEntidade, Integer> {
    @Query("SELECT u FROM FaltaEntidade u WHERE u.aluno = :aluno")
    FaltaEntidade findFaltaEntidadeByAluno(
            @Param("aluno") AlunoEntidade aluno);
}