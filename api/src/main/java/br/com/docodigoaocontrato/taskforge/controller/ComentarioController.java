package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.ComentarioDTO;
import br.com.docodigoaocontrato.taskforge.service.ComentarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
@Tag(name = "Comentarios", description = "Comentarios feitos por usuários") // ------ Exercicio 5 modulo 9.1 -----
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }
    @Operation(summary = "Listar todos os comentários")// ------ Exercicio 5 modulo 9.1 -----
    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> listarComentario() {
        return ResponseEntity.ok(comentarioService.listarComentarios());
    }

    @Operation(summary = "Buscar comentários por ID") // ------ Exercicio 5 modulo 9.1 -----
    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> buscarPorId(@PathVariable Long id) {
        Optional<ComentarioDTO> comentario = comentarioService.buscarPorId(id);
        if (comentario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comentario.get());
    }

    @Operation(summary = "Criar comentário") // ------ Exercicio 5 modulo 9.1 -----
    @PostMapping
    //-------------- Exercicio 5 modulo 8.1 --------------------- @Valid
    public ResponseEntity<ComentarioDTO> criarComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) {
        ComentarioDTO comentarioCriado = comentarioService.criarComentario(comentarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioCriado);
    }
    @Operation(summary = "Atualizar comentário") // ------ Exercicio 5 modulo 9.1 -----
    @PutMapping("/{id}")
    //-------------- Exercicio 5 modulo 8.1 --------------------- @Valid
    public ResponseEntity<ComentarioDTO> atualizarComentario(@PathVariable Long id, @Valid @RequestBody ComentarioDTO comentarioDTO) {
        Optional<ComentarioDTO> atualizada = comentarioService.atualizarComentario(id, comentarioDTO);
        if (atualizada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizada.get());
    }
    @Operation(summary = "Deletar comentário")  // ------ Exercicio 5 modulo 9.1 -----
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComentario(@PathVariable Long id) {
        if (!comentarioService.deletarComentario(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
