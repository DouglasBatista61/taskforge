package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarefaController {

    @GetMapping("/tarefas")
    public TarefaDTO listar(){
        return new TarefaDTO(1, "minhaPrimeiraTarefa", 1, false );
    }
}
