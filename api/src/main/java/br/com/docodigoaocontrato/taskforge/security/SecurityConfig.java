package br.com.docodigoaocontrato.taskforge.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/usuarios", "/usuarios/login").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/error").permitAll()
                        // ------------- Exercicio 5 modulo 7.3 ----------------------------
                        .requestMatchers(HttpMethod.GET, "/tarefas").permitAll()
                        // -----------------------------------------------------------------

                        // ------------- Desafio modulo 7.3 --------------------------------
                        .requestMatchers(HttpMethod.GET, "/ping").permitAll()
                        // -----------------------------------------------------------------
                        .anyRequest().authenticated()
                )
                .sessionManagement(sm ->
                        sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .headers(headers ->
                        headers.frameOptions(frame -> frame.sameOrigin()))
                .exceptionHandling(ex -> ex.authenticationEntryPoint(
                        (request, response, authException) ->
                                response.sendError(401)))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}

//------------------------Exercicio 6 modulo 7.3 ---------------------------
//Comente a linha csrf(csrf -> csrf.disable()) . Suba e faça POST /usuarios/login .
// Anote o status e explique, em uma linha, por que NÃO é 401 nem 200. Depois conserte.
// - 	"status": 403, "error": "Forbidden", .

//------------------------Exercicio 7 modulo 7.3 ---------------------------
//Comente a linha addFilterBefore(...) . Logue,  pegue um token válido e faça GET /tarefas com ele.
//Anote o status e explique por que um crachá válido não entrou. Depois religue a linha.
//- 401.