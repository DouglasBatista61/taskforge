package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.CategoriaDTO;
import br.com.docodigoaocontrato.taskforge.dto.EtiquetaDTO;
import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.model.Etiqueta;
import br.com.docodigoaocontrato.taskforge.service.EtiquetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etiquetas")
@Tag(name = "Etiquetas", description = "Etiquetas que identificam prioridades por cor")
public class EtiquetaController {

    private final EtiquetaService etiquetaService;

    public EtiquetaController(EtiquetaService etiquetaService) {
        this.etiquetaService = etiquetaService;
    }


    // ------------------- Desafio 6.2 -----------------------------------------------------------
    @Operation(summary = " Busca uma etiqueta por ID")
    @GetMapping("/{id}")
    public ResponseEntity<EtiquetaDTO> buscarPorId(@PathVariable Long id) {
        Optional<EtiquetaDTO> etiqueta = etiquetaService.buscarPorId(id);
        if (etiqueta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(etiqueta.get());
    }
    @Operation(summary = " Atualiza status da etiqueta")
    @PutMapping("/{id}")
    public ResponseEntity<EtiquetaDTO> atualizarEtiqueta(@PathVariable Long id, @RequestBody EtiquetaDTO etiquetaDTO) {
        Optional<EtiquetaDTO> atualizada = etiquetaService.atualizarEtiqueta(id, etiquetaDTO);
        if (atualizada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizada.get());
    }

    //--------------------------------------------------------------------------------------------
    @Operation(summary = " Cria uma etiqueta")
    @PostMapping
    public ResponseEntity<EtiquetaDTO> criarEtiqueta(@RequestBody EtiquetaDTO etiquetaDTO) {
        EtiquetaDTO etiquetaCriada = etiquetaService.criarEtiqueta(etiquetaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(etiquetaCriada);
    }

    // ------------------- Desafio 6.3 -----------------------------------------------------------
    @Operation(summary = " Deleta uma etiqueta")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEtiqueta(@PathVariable Long id) {
        if (!etiquetaService.deletarEtiqueta(id)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @Operation(summary = " Busca uma etiqueta por cor")
    @GetMapping
    public List<EtiquetaDTO> buscarPorCor(
            @RequestParam(required = false) String cor) {
        return etiquetaService.buscarCor(cor);
    }

    // -------------------------------------------------------------------------------------------
}
