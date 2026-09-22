package br.com.docodigoaocontrato.taskforge.exercicios.exercicio03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SobreController {

    @GetMapping("/sobre")
    public String sobre(){
        return "Douglas - aprendendo Java e Spring no Do Código ao Contrato";
    }

}
