package br.com.docodigoaocontrato.taskforge.exercicios.desafio;

import br.com.docodigoaocontrato.taskforge.exercicios.exercicio06.Genero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Desafio {

    @GetMapping("/catalogo")
    public CatalogoDTO midia() {
        List<MidiaDTO> midiaDTOS = new ArrayList<>();
        midiaDTOS.add(new MidiaDTO("Duna", 8.7, Genero.ACAO, 155));
        midiaDTOS.add(new MidiaDTO("Café com Código", 9.1, Genero.TECNOLOGIA, 28));
        midiaDTOS.add(new MidiaDTO("Tropa de Elite", 8.0, Genero.ACAO, 115));
        CatalogoDTO catalogoDTO = new CatalogoDTO("StreamFlix", midiaDTOS);
        return catalogoDTO;
    }
}
