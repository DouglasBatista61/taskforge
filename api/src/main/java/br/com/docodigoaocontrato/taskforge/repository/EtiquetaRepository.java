package br.com.docodigoaocontrato.taskforge.repository;

import br.com.docodigoaocontrato.taskforge.model.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
}
