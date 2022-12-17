package br.com.gestao_escola.persistencia.repositorio;

import br.com.gestao_escola.persistencia.entidade.CpfEntidade;
import br.com.gestao_escola.persistencia.entidade.ResponsavelEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepositorio extends JpaRepository<ResponsavelEntidade, CpfEntidade> {

    ResponsavelEntidade findOnesByCpf(CpfEntidade cpf);

}
