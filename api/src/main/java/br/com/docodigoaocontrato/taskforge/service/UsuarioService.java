package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.UsuarioCadastroDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Usuario;
import br.com.docodigoaocontrato.taskforge.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }



    //    public Optional<UsuarioDTO> cadastrar(UsuarioCadastroDTO dto) {
    //        if (usuarioRepository.existsUsuarioByEmail(dto.getEmail())) {
    //            return Optional.empty();
    //        }
    //        Usuario usuario = new Usuario(dto.getNome(), dto.getEmail(), dto.getSenha());
    //        return usuario = usuarioRepository.save(usuario);
    //    }
    //
    //
    //    }
}

