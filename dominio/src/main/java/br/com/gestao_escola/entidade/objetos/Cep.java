package br.com.gestao_escola.entidade.objetos;

public class Cep {

    private String numero;

    public Cep(String numero) {
        if (numero == null || !numero.matches("^(\\d{5}-\\d{3})$"))
        {
            throw new IllegalArgumentException("CEP invalido");
        }
        this.numero = numero;
    }
}
