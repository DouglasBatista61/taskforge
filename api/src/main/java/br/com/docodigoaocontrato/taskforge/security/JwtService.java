package br.com.docodigoaocontrato.taskforge.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtService {

    private static final String SEGREDO = "asdkasjdlsad-213213sdsa-21321sqd-sadas";
    private final SecretKey chave = Keys.hmacShaKeyFor(SEGREDO.getBytes(StandardCharsets.UTF_8));

    public String gerarToken(String email, String nome) {
        return Jwts.builder()
                .subject(email) // de quem é o token
                .issuedAt(new Date()) // data que o token foi emitido = AGORA
                .expiration(new Date(System.currentTimeMillis() + 1000*60*60)) // prazo de validade do token
                .signWith(chave) // o lacre da assinatura
                .claim("nome", nome)
                .compact();
    }

    public String validarObterEmail(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(chave) // conferir o token com a chave
                    .build()
                    .parseSignedClaims(token) // abrir o token estoura um erro
                    .getPayload()
                    .getSubject(); // o email do usuario
        } catch (Exception ex) {
            return null; // autenticacao invalida
        }
    }
}
