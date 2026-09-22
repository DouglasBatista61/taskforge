package br.com.docodigoaocontrato.taskforge.exercicios.exercicio07;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TarefaDTOExercicio {

    @GetMapping("/tarefas/todas")
    public List<TarefaDTO> todas(){
        List<TarefaDTO> tarefas = new ArrayList<>();
        tarefas.add(new TarefaDTO(1l, "Estudar Java", 1, false));
        tarefas.add(new TarefaDTO(2l, "Revisar PR", 2, true));
        tarefas.add(new TarefaDTO(3l, "Subir a API", 1, false));
        return tarefas;
    }
}
