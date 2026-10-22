package br.com.docodigoaocontrato.taskforge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingControllerDesafio {

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
}
