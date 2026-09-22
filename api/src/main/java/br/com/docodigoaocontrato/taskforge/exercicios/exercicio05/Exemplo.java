package br.com.docodigoaocontrato.taskforge.exercicios.exercicio05;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exemplo{

    @GetMapping("/tarefas/exemplo")
    public TarefaDTO exemplo(){
        return new TarefaDTO(3l, "Estudar Java", 1,false);

    }


}
