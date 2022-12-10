package br.com.gestao_escola.entidade.forum;

import lombok.Data;

@Data
public class OrganizaForum {

    private long id;

    private String titulo;

    private Forum forum;

    public OrganizaForum(String titulo, Forum forum) {
        if(titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Titulo não pode ser nulo ou vazio");
        }
        if(titulo.length() > 50) {
            throw new IllegalArgumentException("Titulo não pode ter mais de 50 caracteres");
        }

        this.titulo = titulo;
        this.forum = forum;
    }
}
