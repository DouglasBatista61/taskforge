package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.ComentarioDTO;
import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.service.ComentarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> listarTodos() {
        return ResponseEntity.ok(comentarioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> criarComentario(@RequestBody ComentarioDTO comentarioDTO) {
        ComentarioDTO comentarioCriado = comentarioService.criarComentario(comentarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioCriado);
    }
}
