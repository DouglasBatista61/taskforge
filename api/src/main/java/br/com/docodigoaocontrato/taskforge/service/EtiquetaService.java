package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.EtiquetaDTO;
import br.com.docodigoaocontrato.taskforge.model.Etiqueta;
import br.com.docodigoaocontrato.taskforge.repository.EtiquetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetaService {

    private final EtiquetaRepository etiquetaRepository;

    public EtiquetaService(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    public List<EtiquetaDTO> listarTodas() {
        return etiquetaRepository.findAll()
                .stream()
                .map(etiqueta -> toDto(etiqueta))
                .toList();
    }

    public EtiquetaDTO criarEtiqueta(EtiquetaDTO etiquetaDTO) {
        Etiqueta etiqueta = toEntity(etiquetaDTO);
        return toDto(etiquetaRepository.save(etiqueta));
    }

    private EtiquetaDTO toDto(Etiqueta etiqueta) {
        return new EtiquetaDTO(etiqueta.getId(), etiqueta.getNome(),
                etiqueta.getCor());
    }

    private Etiqueta toEntity(EtiquetaDTO etiquetaDTO) {
        return new Etiqueta(etiquetaDTO.getNome(),
                etiquetaDTO.getCor());
    }
}
