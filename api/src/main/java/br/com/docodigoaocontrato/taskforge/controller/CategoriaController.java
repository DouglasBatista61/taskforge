package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.CategoriaDTO;
import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<CategoriaDTO> buscarTodos() {
        return categoriaService.buscarTodas();

    }
    @PostMapping
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO criarCategoria = categoriaService.criarCategoria(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarCategoria);

    }
    //------------------------------ Exercicio 2 - 6.2 ----------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id){
        Optional<CategoriaDTO> categoria = categoriaService.buscarPorId(id);
        if(categoria.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoria.get());
    }
    // --------------------------------------------------------------------------------

    //------------------------------ Exercicio 5 - 6.2 ----------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> atualizarTarefa(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO){
        Optional<CategoriaDTO> atualizada = categoriaService.atualizarCategoria(id, categoriaDTO);
        if (atualizada.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizada.get());
    }
    // --------------------------------------------------------------------------------
}
