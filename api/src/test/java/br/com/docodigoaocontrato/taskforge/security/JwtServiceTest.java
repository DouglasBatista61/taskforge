package br.com.docodigoaocontrato.taskforge.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class JwtServiceTest {

    private final JwtService jwtService = new JwtService();

    // -------------------- Exercício 1 8.2 --------------------------------
    @Test
    void deveDevolverOEmailDeQuemGerouOToken() {
        // DADO que um email e um nome
        String email = "ana@email.com";
        String nome = "ana";

        // QUANDO eu gero um token e depois leio o token de volta
        String token = jwtService.gerarToken(email, nome);
        String emailDoToken = jwtService.validarObterEmail(token);

        // ENTAO o email que retorna é o mesmo que entrou
        assertEquals("ana@email.com", emailDoToken);
    }
    //-----------------------------------------------------------------------

    // -------------------- Exercício 2 8.2 ---------------------------------
    @Test
    void deveDevolverNullQuandoOTokenFoiAdulterado() {
        // DADO que um token foi adulterado por alguem
        String token = jwtService.gerarToken("teste@teste.com", "teste");
        String tokenAdulterado = token.substring(0, token.length() -2) + "xx";

        // QUANDO eu tentar ler
        String emailDoToken = jwtService.validarObterEmail(tokenAdulterado);

        // ENTAO
        assertNull(emailDoToken);
    }
}
