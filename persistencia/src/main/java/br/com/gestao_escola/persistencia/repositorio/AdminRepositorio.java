package br.com.gestao_escola.persistencia.repositorio;

import br.com.gestao_escola.persistencia.entidade.AdminEntidade;
import br.com.gestao_escola.persistencia.entidade.CpfEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositorio extends JpaRepository<AdminEntidade, CpfEntidade> {

    AdminEntidade findOnesByCpf(CpfEntidade cpf);
}