package br.com.docodigoaocontrato.taskforge.repository;

import br.com.docodigoaocontrato.taskforge.model.Midia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MidiaRepository extends JpaRepository<Midia, Long> {
    List<Midia> findAll();

    List<Midia> findByTipo(String tipo);

    List<Midia> findByTipoIgnoreCase(String tipo);

    List<Midia> findByAvaliacaoIsGreaterThan(Double avaliacaoIsGreaterThan);
}
