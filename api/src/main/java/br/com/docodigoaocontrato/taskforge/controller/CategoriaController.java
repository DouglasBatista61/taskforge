package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.CategoriaDTO;
import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.model.Categoria;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import br.com.docodigoaocontrato.taskforge.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
