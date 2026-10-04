package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.model.Midia;
import br.com.docodigoaocontrato.taskforge.repository.MidiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MidiaService {

    private final MidiaRepository midiaRepository;

    public MidiaService(MidiaRepository midiaRepository) {
        this.midiaRepository = midiaRepository;
    }

    public List<Midia> buscarTodas() {
        return midiaRepository.findAll();
    }

    public List<Midia> buscarFilmes(String tipo) {
        List<Midia> buscarTipo;
        if (tipo == null) {
            buscarTipo = midiaRepository.findByTipoIgnoreCase("serie");
        } else {
            buscarTipo = midiaRepository.findByTipo(tipo);
        }
        return buscarTipo.stream()
                .map(filme -> toDto(filme))
                .toList();
    }

    public List<Midia> buscarAvaliacao(){
        List<Midia> bemAvaliadas;
        bemAvaliadas = midiaRepository.findByAvaliacaoIsGreaterThan(8.6);
        return bemAvaliadas;
    }



    private Midia toDto(Midia midia) {
        return new Midia(midia.getId(), midia.getTitulo(),
                midia.getTipo(), midia.getDuracaoMin(), midia.getAvaliacao(),
                midia.getAnoLancamento());
    }
}

