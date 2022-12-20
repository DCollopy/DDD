package br.com.gestao_escola.kafka.model;

import lombok.Data;

@Data
public class OrganizaForumDTO {

    private String titulo;

    private ForumDTO forum;
}