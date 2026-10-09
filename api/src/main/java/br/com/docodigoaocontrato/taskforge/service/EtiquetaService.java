package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.EtiquetaDTO;
import br.com.docodigoaocontrato.taskforge.model.Etiqueta;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import br.com.docodigoaocontrato.taskforge.repository.EtiquetaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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

    // ------------------- Desafio 6.2 -----------------------------------------------------------

    public Optional<EtiquetaDTO> buscarPorId(Long id){
        return etiquetaRepository.findById(id)
                .map(etiqueta -> toDto(etiqueta));
    }

    public Optional<EtiquetaDTO> atualizarEtiqueta(Long id, EtiquetaDTO etiquetaDTO){
        Optional<Etiqueta> etiquetaEncontrada = etiquetaRepository.findById(id);
        if (etiquetaEncontrada.isEmpty()) {
            return Optional.empty();
        }

        Etiqueta etiqueta = etiquetaEncontrada.get();
        etiqueta.setNome(etiquetaDTO.getNome());
        etiqueta.setCor(etiquetaDTO.getCor());


        return Optional.of(toDto(etiquetaRepository.save(etiqueta)));
    }


    //--------------------------------------------------------------------------------------------


    private EtiquetaDTO toDto(Etiqueta etiqueta) {
        return new EtiquetaDTO(etiqueta.getId(), etiqueta.getNome(),
                etiqueta.getCor());
    }

    private Etiqueta toEntity(EtiquetaDTO etiquetaDTO) {
        return new Etiqueta(etiquetaDTO.getNome(),
                etiquetaDTO.getCor());
    }
}
