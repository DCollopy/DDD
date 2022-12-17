package br.com.gestao_escola.persistencia.repositorio;

import br.com.gestao_escola.persistencia.entidade.AulaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepositorio extends JpaRepository<AulaEntidade, Float> {

}
