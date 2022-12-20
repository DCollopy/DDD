package br.com.gestao_escola.persistencia.repositorio;


import br.com.gestao_escola.persistencia.entidade.NotaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface NotaRepositorio extends JpaRepository<NotaEntidade, Integer> {
}
