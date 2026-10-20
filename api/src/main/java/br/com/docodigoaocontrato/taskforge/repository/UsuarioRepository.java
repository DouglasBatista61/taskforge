package br.com.docodigoaocontrato.taskforge.repository;

import br.com.docodigoaocontrato.taskforge.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // cadastro (7.1): so quer saber SE existe -> boolean, query mais ligeira.
    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findById(Long id);

    boolean existsUsuarioByEmail(String email);

    List<Usuario> findByAtivo(Boolean ativo);
}



// login (7.2): agora a gente PRECISA do usuario (pra pegar a senha e comparar).
// por isso aqui e findByEmail, que traz o usuario (ou vazio) num Optional.
//Optional<Usuario> findByEmail(String email);