package br.com.gestao_escola.web.model;

import lombok.Data;

@Data
public class OrganizaForumDTO {
    private long id;

    private String titulo;

    private ForumDTO forum;
}