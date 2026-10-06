package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.MidiaDTO;
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

    public List<MidiaDTO> buscarTodas() {
        return midiaRepository.findAll()
                .stream()
                .map(midia -> toDto(midia))
                .toList();
    }

    public List<MidiaDTO> buscarFilmes(String tipo) {
        List<Midia> buscarTipo;
        if (tipo == null) {
            buscarTipo = midiaRepository.findByTipoIgnoreCase("filme");
        } else {
            buscarTipo = midiaRepository.findByTipo(tipo);
        }
        return buscarTipo.stream()
                .map(filme -> toDto(filme))
                .toList();
    }

    public List<MidiaDTO> buscarAvaliacao() {
        return midiaRepository.findByAvaliacaoIsGreaterThan(8.6)
                .stream()
                .map(avaliacao -> toDto(avaliacao))
                .toList();
    }

    private MidiaDTO toDto(Midia midia) {
        return new MidiaDTO(midia.getId(), midia.getTitulo(), midia.getTipo(),
                midia.getDuracaoMin(), midia.getAvaliacao(), midia.getAnoLancamento());
    }
    private Midia toEntity(MidiaDTO midiaDTO){
        return new Midia(midiaDTO.getId(), midiaDTO.getTitulo(), midiaDTO.getTipo(),
                midiaDTO.getDuracaoMin(), midiaDTO.getAvaliacao(), midiaDTO.getAnoLancamento());
    }
}

