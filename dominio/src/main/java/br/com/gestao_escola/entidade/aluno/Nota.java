package br.com.gestao_escola.entidade.aluno;

import br.com.gestao_escola.entidade.aula.Aula;
import lombok.Data;

@Data
public class Nota {

    private float id;
    private float nota;
    private Aula aula;
    private Aluno aluno;

    public Nota(float nota, Aula aula, Aluno aluno) {
       if(nota < 0 || nota > 10) {
           throw new IllegalArgumentException("Nota invalida");
       }
       if(aula == null) {
           throw new IllegalArgumentException("Aula invalida");
       }

        this.nota = nota;
        this.aula = aula;
        this.aluno = aluno;
    }
}
