package br.com.gestao_escola.model;

import br.com.gestao_escola.entidade.objetos.Endereco;
import lombok.Data;

@Data
public class EnderecoDTO {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private CepDTO cep;

    public EnderecoDTO() {
    }

    public Endereco converteDtoParaEndereco() {
        return new Endereco(this.getRua()
                , this.getNumero()
                , this.getBairro()
                , this.getCidade()
                , this.getEstado()
                , this.getCep().converteDtoParaCep());
    }
}
