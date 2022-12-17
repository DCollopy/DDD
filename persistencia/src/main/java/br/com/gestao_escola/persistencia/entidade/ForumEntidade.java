package br.com.gestao_escola.persistencia.entidade;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "forum")
public class ForumEntidade  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private float id;

    private String mensagem;

    private String identidade;

    private final LocalDate data = LocalDate.now();
}
