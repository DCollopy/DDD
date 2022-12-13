package br.com.gestao_escola.web.model;

import br.com.gestao_escola.dominio.entidade.objetos.Telefone;
import lombok.Data;

@Data
public class TelefoneDTO {

    private String ddd;

    private String numero;

    public TelefoneDTO() {
    }

    public Telefone converteDtoParaTelefone() {
        return new Telefone(this.getDdd(), this.getNumero());
    }
}