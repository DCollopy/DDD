package br.com.gestao_escola.casodeuso;


import br.com.gestao_escola.casodeuso.forum.ForumValidaTest;
import br.com.gestao_escola.entidade.forum.Forum;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class ForumTest {

    protected ForumValidaTest forumTest = new ForumValidaTest();


    @Test
    void valida() {

        assertThrows(IllegalArgumentException.class, () -> forumTest.valida(new Forum(null, "Identidade"), 1));

        assertThrows(IllegalArgumentException.class, () -> forumTest.valida(new Forum("Mensagem", null), 1));

        assertThrows(IllegalArgumentException.class, () -> forumTest.valida(new Forum("Mensagem", "Identidade"), 0));

        assertThrows(IllegalArgumentException.class, () -> forumTest.valida(new Forum("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
                , "Identidade"), 1));

    }

    @Test
    void criaForum() {
        assertNotNull(forumTest.criaForum(1, new Forum("Mensagem", "Identidade")));
    }
}