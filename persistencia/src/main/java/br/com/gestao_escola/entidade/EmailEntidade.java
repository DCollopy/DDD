package br.com.gestao_escola.entidade;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
@Embeddable
@Data
@Table(name = "email")
public class EmailEntidade implements Serializable {

    private String email;

}
