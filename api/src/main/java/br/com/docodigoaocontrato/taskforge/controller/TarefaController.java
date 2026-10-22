package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> buscarPorId(@PathVariable Long id) {
        Optional<TarefaDTO> tarefa = tarefaService.buscarPorId(id);
        if (tarefa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefa.get());
    }

    // POST /tarefas -> 201
    @PostMapping
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO tarefaCriada = tarefaService.criarTarefa(tarefaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
    }

    // PUT /tarefas/2 -> 200 | 404
    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
        Optional<TarefaDTO> atualizada = tarefaService.atualizarTarefa(id, tarefaDTO);
        if (atualizada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizada.get());
    }

    // DELETE /tarefas/2 -> 204 | 404
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        if (!tarefaService.deletarTarefa(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}