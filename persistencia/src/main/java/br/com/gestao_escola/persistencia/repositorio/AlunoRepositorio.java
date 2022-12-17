package br.com.gestao_escola.persistencia.repositorio;

import br.com.gestao_escola.persistencia.entidade.AlunoEntidade;
import br.com.gestao_escola.persistencia.entidade.CpfEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepositorio  extends JpaRepository<AlunoEntidade, CpfEntidade> {

    AlunoEntidade findOnesByCpf(CpfEntidade cpf);
}
