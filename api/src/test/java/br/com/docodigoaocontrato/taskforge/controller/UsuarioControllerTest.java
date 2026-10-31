package br.com.docodigoaocontrato.taskforge.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:testes")
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;
// ------------------ Exercício 8 modulo 8.2 ---------------------------------
    @Test
    void deveRetorna400QuandoOEmailDoCadastroForInvalido() throws Exception {
        mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "nome": "Ana",
                            "email": "abc",
                            "senha": "123456"
                        }
                        """))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.campos.email").value("O email está inválido"));
    }
}

