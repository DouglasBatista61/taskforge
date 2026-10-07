package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.ComentarioDTO;
import br.com.docodigoaocontrato.taskforge.service.ComentarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> listarComentario() {
        return ResponseEntity.ok(comentarioService.listarComentarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> buscarPorId(@PathVariable Long id) {
        Optional<ComentarioDTO> comentario = comentarioService.buscarPorId(id);
        if (comentario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comentario.get());
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> criarComentario(@RequestBody ComentarioDTO comentarioDTO) {
        ComentarioDTO comentarioCriado = comentarioService.criarComentario(comentarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComentarioDTO> atualizarComentario(@PathVariable Long id, @RequestBody ComentarioDTO comentarioDTO) {
        Optional<ComentarioDTO> atualizada = comentarioService.atualizarComentario(id, comentarioDTO);
        if (atualizada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizada.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComentario(@PathVariable Long id) {
        if (!comentarioService.deletarComentario(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
