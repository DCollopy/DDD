package br.com.gestao_escola.persistencia.entidade;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "administrador")
public class AdminEntidade extends PessoaEntidade {

    private  String matricula;

    private  String perfil;

    public AdminEntidade(){}
}