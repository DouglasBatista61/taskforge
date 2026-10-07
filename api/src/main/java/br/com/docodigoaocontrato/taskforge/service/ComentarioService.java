package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.ComentarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Comentario;
import br.com.docodigoaocontrato.taskforge.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public List<ComentarioDTO> listarComentarios() {
        return comentarioRepository.findAll()
                .stream()
                .map(comentario -> toDto(comentario))
                .toList();
    }

    public ComentarioDTO criarComentario(ComentarioDTO comentarioDTO) {
        Comentario comentario = toEntity(comentarioDTO);
        return toDto(comentarioRepository.save(comentario));
    }

    public Optional<ComentarioDTO> atualizarComentario(Long id, ComentarioDTO comentarioDTO) {
        Optional<Comentario> atualizar = comentarioRepository.findById(id);
        if (atualizar.isEmpty()) {
            return Optional.empty();
        }

        Comentario comentarioAtualizado = atualizar.get();
        comentarioAtualizado.setAutor(comentarioDTO.getAutor());
        comentarioAtualizado.setDescricao(comentarioDTO.getDescricao());

        return Optional.of(toDto(comentarioRepository.save(comentarioAtualizado)));
    }

    public Optional<ComentarioDTO> buscarPorId(Long id) {
        return comentarioRepository.findById(id)
                .map(comentario -> toDto(comentario));
    }

    public boolean deletarComentario(Long id) {
        if (!comentarioRepository.existsById(id)) {
            return false;
        }
        comentarioRepository.deleteById(id);
        return true;
    }

    private ComentarioDTO toDto(Comentario comentario) {
        return new ComentarioDTO(comentario.getId(), comentario.getDescricao(),
                comentario.getAutor());
    }

    private Comentario toEntity(ComentarioDTO comentarioDTO) {
        return new Comentario(comentarioDTO.getId(), comentarioDTO.getDescricao(),
                comentarioDTO.getAutor());
    }
}
