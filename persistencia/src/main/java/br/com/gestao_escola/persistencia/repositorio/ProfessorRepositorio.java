package br.com.gestao_escola.persistencia.repositorio;

import br.com.gestao_escola.persistencia.entidade.CpfEntidade;
import br.com.gestao_escola.persistencia.entidade.ProfessorEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepositorio extends JpaRepository<ProfessorEntidade, CpfEntidade> {

    ProfessorEntidade findOnesByCpf(CpfEntidade cpf);
}