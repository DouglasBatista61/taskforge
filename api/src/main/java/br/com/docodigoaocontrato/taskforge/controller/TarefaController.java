package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// A controller so traduz HTTP <-> Java. Os "if" daqui escolhem o codigo HTTP, nao regra.
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    // GET /tarefas            -> todas
    // GET /tarefas?concluida=true  -> so as concluidas
    // required = false: sem o parametro, concluida chega null
    @GetMapping
    public ResponseEntity<List<TarefaDTO>> buscarTodas(
            @RequestParam(required = false) Boolean concluida) {
        return ResponseEntity.ok(tarefaService.buscarTodos(concluida));
    }
    // --------------- Exercicio 5 modulo 5.2 ---------------------------------------


    @GetMapping("/pendentes")
    public ResponseEntity<List<TarefaDTO>> buscarPendentes(
            @RequestParam(required = false) Boolean concluida) {
        return ResponseEntity.ok(tarefaService.buscarPendentes(concluida));
    }

    //-------------------------------------------------------------------------------

    // ------------------Exercicio 6 modulo 5.2 -------------------------------------

    @GetMapping("/urgentes")
    public ResponseEntity<List<TarefaDTO>> buscarUrgentes(
            @RequestParam(required = false) Boolean concluida, Integer prioridade) {
        return ResponseEntity.ok(tarefaService.buscarUrgentes(prioridade, concluida));
    }
    // ------------------------------------------------------------------------------

    // GET /tarefas/2 -> 200 | 404
    // ------------------Desafio modulo 8.1 ------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> buscarPorId(@PathVariable Long id) {
        TarefaDTO tarefa = tarefaService.buscarTarefaPorId(id);
        return ResponseEntity.ok(tarefa);
    }
    // ------------------------------------------------------------------------------

    // Novo POST /tarefas -> 201
    //-------------- Exercicio 1 modulo 8.1 --------------------- @Valid
    @PostMapping
    public ResponseEntity<TarefaDTO> criarTarefa(@Valid @RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO tarefaCriada = tarefaService.criarTarefa(tarefaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
    }

    // Novo PUT /tarefas/2 -> 200 | 404
    //-------------- Exercicio 2 modulo 8.1 --------------------- @Valid
    // ------------------Desafio Extra modulo 8.1 ------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable Long id, @Valid @RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO atualizada = tarefaService.atualizarTarefa(id, tarefaDTO);
        return ResponseEntity.ok(atualizada);
    }

    // Novo DELETE /tarefas/2 -> 204 | 404
    // ------------------Desafio Extra modulo 8.1 ------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
       tarefaService.deletarTarefa(id);
       return ResponseEntity.noContent().build();
    }
}