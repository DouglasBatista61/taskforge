package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.CategoriaDTO;
import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@Tag(name = "Categorias", description = "Categorias de tarefas")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }


    // -------------------------- Exercicio 6 modulo 6.3-------------------------
    @Operation(summary = "Buscar por Ativas")
    @GetMapping
    public List<CategoriaDTO> buscarAtivas(
            @RequestParam(required = false) Boolean ativa) {
        return categoriaService.buscarTodas(ativa);
    }

    // ----------------------------------------------------------------------------------
    @Operation(summary = "Criar categoria")
    @PostMapping
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO criarCategoria = categoriaService.criarCategoria(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarCategoria);

    }
    //------------------------------ Exercicio 2 - 6.2 ----------------------------------
    @Operation(summary = "Buscar categoria por ID")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id) {
        Optional<CategoriaDTO> categoria = categoriaService.buscarPorId(id);
        if (categoria.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoria.get());
    }
    // ----------------------------------------------------------------------------------

    //------------------------------ Exercicio 5 - 6.2 ----------------------------------
    @Operation(summary = "Atualizar categoria")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        Optional<CategoriaDTO> atualizada = categoriaService.atualizarCategoria(id, categoriaDTO);
        if (atualizada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizada.get());
    }
    // ---------------------------------------------------------------------------------

    //------------------------------ Exercicio 2 - 6.3 ----------------------------------
    @Operation(summary = "Deletar categoria")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        if (!categoriaService.deletarCategoria(id)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
