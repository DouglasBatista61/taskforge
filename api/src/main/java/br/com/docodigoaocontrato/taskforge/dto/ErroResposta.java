package br.com.docodigoaocontrato.taskforge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErroResposta {


    //------------ Exercício 6 modulo 8.1 -------------------------------
    private Integer status;
    private String mensagem;
    private Map<String, String> campos; //campo nome, messagem: campo inválido


}
