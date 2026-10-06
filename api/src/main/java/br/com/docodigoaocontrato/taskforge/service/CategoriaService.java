package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.CategoriaDTO;
import br.com.docodigoaocontrato.taskforge.model.Categoria;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import br.com.docodigoaocontrato.taskforge.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> buscarTodas() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoria -> toDto(categoria))
                .toList();
    }

    public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO){
        Categoria categoria = toEntity(categoriaDTO);
        return toDto(categoriaRepository.save(categoria));

    }

    private CategoriaDTO toDto(Categoria categoria) {
        return new CategoriaDTO(categoria.getId(), categoria.getNome(),
                categoria.getAtiva());

    }

    private Categoria toEntity(CategoriaDTO categoriaDto) {
        return new Categoria(categoriaDto.getNome(), categoriaDto.getAtiva());
    }
}