package br.com.gestao_escola.persistencia.repositorio;

import br.com.gestao_escola.persistencia.entidade.OrganizaForumEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizaForumRepositorio extends JpaRepository<OrganizaForumEntidade, Integer> {
}