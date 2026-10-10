package br.com.docodigoaocontrato.taskforge.repository;

import br.com.docodigoaocontrato.taskforge.model.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {

    Optional<Etiqueta> findById(Long id);

    List<Etiqueta> findByCor(String cor);

    List<Etiqueta> findByCorContainsIgnoreCase(String cor);
}
