package br.com.docodigoaocontrato.taskforge.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:testes")
@AutoConfigureMockMvc
public class DocumentacaoECorsTest {

    @Autowired
    private MockMvc mockMvc;

    // --------------- Exercício 8 modulo 9.1 -------------------------------------
    @Test
    void apiDocsDeveSerPublicoETerTituloTaskForgeApi() throws Exception {
        mockMvc.perform(get("/v3/api-docs")) // sem header Authorization
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.info.title").value("TaskForge API"));
    }

    // --------------- Desafio modulo 9.1 -------------------------------------
    @Test
    void deveLiberarOrigemQuandoForConvidado() throws Exception {
        mockMvc.perform(options("/tarefas")
                        .header("Origin", "http://localhost:5173")
                        .header("Access-Control-Request-Method", "GET"))
                .andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin", "http://localhost:5173"));

    }

    @Test
    void naoDeveLiberarQuandoOrigemNaoForConvidado() throws Exception {
        mockMvc.perform(options("/tarefas")
                        .header("Origin", "http://localhost:3000")
                        .header("Access-Control-Request-Method", "GET"))
                .andExpect(status().isForbidden())
                .andExpect(header().doesNotExist("Access-Control-Allow-Origin"));
    }

}


