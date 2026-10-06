package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.EtiquetaDTO;
import br.com.docodigoaocontrato.taskforge.service.EtiquetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etiquetas")
public class EtiquetaController {

    private final EtiquetaService etiquetaService;

    public EtiquetaController(EtiquetaService etiquetaService) {
        this.etiquetaService = etiquetaService;
    }

    @GetMapping
    public List<EtiquetaDTO> buscarTodas() {
        return etiquetaService.listarTodas();
    }

    @PostMapping
    public ResponseEntity<EtiquetaDTO> criarEtiqueta(@RequestBody EtiquetaDTO etiquetaDTO) {
        EtiquetaDTO etiquetaCriada = etiquetaService.criarEtiqueta(etiquetaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(etiquetaCriada);
    }

}
