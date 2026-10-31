package br.com.docodigoaocontrato.taskforge.service;


import br.com.docodigoaocontrato.taskforge.dto.LoginDTO;
import br.com.docodigoaocontrato.taskforge.dto.LoginRespostaDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioCadastroDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Usuario;
import br.com.docodigoaocontrato.taskforge.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// ------------------------------ Exercicio 6 modulo 8.2 --------------------------

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    // ------------------------------ Exercicio 6 modulo 8.2 --------------------------
    @Test
    void naoDeveCadastrarQuandoOEmailExistir() {
        when(usuarioRepository.existsUsuarioByEmail("ana@email.com")).thenReturn(true);
        Optional<UsuarioDTO> resultado = usuarioService.cadastrar(new UsuarioCadastroDTO("teste",
                "ana@email.com", "ana123"));
        assertTrue(resultado.isEmpty());
        verify(usuarioRepository, never()).save(any(Usuario.class));
    }

    // ------------------------------ Exercicio 7 modulo 8.2 --------------------------

    @Test
    void naoDeveLogarSeASenhaEstiverIncorreta() {
        Usuario usuario = new Usuario("ana", "ana@email.com", new BCryptPasswordEncoder()
                .encode("123456"), true);
        when(usuarioRepository.findByEmail("ana@email.com")).thenReturn(Optional.of(usuario));
        Optional<LoginRespostaDTO> resultado = usuarioService.login(new LoginDTO("ana@email.com", "errada"));
        assertTrue(resultado.isEmpty());

    }

    @Test
    void deveLogarSeASenhaEstiverCorreta() {
        Usuario usuario = new Usuario("ana", "ana@email.com", new BCryptPasswordEncoder()
                .encode("123456"), true);
        when(usuarioRepository.findByEmail("ana@email.com")).thenReturn(Optional.of(usuario));
        Optional<LoginRespostaDTO> resultado = usuarioService.login(new LoginDTO("ana@email.com", "123456"));
        assertTrue(resultado.isPresent());
        assertFalse(resultado.get().getToken().isBlank());
    }
}
