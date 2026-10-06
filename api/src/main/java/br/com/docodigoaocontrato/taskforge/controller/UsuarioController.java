package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.UsuarioCadastroDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

//    @PostMapping
//    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO){
//        Optional<UsuarioDTO> usuarioCriado = usuarioService.cadastrar(usuarioCadastroDTO);
//        if(usuarioCriado.isEmpty()){

//            return ResponseEntity.notFound().build();
//        }
//        return new ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado.get());
//
//    }
}
