package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.ComentarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Comentario;
import br.com.docodigoaocontrato.taskforge.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public List<ComentarioDTO> listarTodos() {
        return comentarioRepository.findAll()
                .stream()
                .map(comentario -> toDto(comentario)).
                toList();
    }

    public ComentarioDTO criarComentario(ComentarioDTO comentarioDTO) {
        Comentario comentario = toEntity(comentarioDTO);
        return toDto(comentarioRepository.save(comentario));
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
