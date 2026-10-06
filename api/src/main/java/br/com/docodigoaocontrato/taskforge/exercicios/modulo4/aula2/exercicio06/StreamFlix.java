package br.com.docodigoaocontrato.taskforge.exercicios.modulo4.aula2.exercicio06;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamFlix {

    @GetMapping("/midias/exemplo")
    public MidiaDTO midia(){
        return new MidiaDTO("Duna", 8.7, Genero.ACAO, 155);

    }
}
