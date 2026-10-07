package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.MidiaDTO;
import br.com.docodigoaocontrato.taskforge.model.Midia;
import br.com.docodigoaocontrato.taskforge.service.MidiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/midias")
public class MidiaController {

    private final MidiaService midiaService;

    public MidiaController(MidiaService midiaService) {
        this.midiaService = midiaService;
    }

    @GetMapping
    public List<MidiaDTO> buscarMidias() {
        return midiaService.buscarTodas();
    }

    @GetMapping("/filmes")
    public ResponseEntity<List<MidiaDTO>> filmes(
            @RequestParam(required = false) String tipo) {
        return ResponseEntity.ok(midiaService.buscarFilmes(tipo));

    }
    @GetMapping("/bem-avaliadas")
    public ResponseEntity<List<MidiaDTO>> bemAvaliadas(){
        return  ResponseEntity.ok(midiaService.buscarAvaliacao());

    }

}
