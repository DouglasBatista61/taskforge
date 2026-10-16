package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.*;
import br.com.docodigoaocontrato.taskforge.model.Usuario;
import br.com.docodigoaocontrato.taskforge.repository.UsuarioRepository;
import br.com.docodigoaocontrato.taskforge.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final JwtService jwtService = new JwtService();


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // ---- 7.1: cadastro ----
    public Optional<UsuarioDTO> cadastrar(UsuarioCadastroDTO dto) {
        if (usuarioRepository.existsUsuarioByEmail(dto.getEmail())) {
            return Optional.empty();
        }
        String senhaCriptografada = encoder.encode(dto.getSenha());
        Usuario usuario = new Usuario(dto.getNome(), dto.getEmail(), senhaCriptografada, true);
        return Optional.of(toDto(usuarioRepository.save(usuario)));
    }

    // ---- 7.2: login ---------- Exercicio 3 modulo 7.2 ---------------------------------------
    // devolve vazio quando NAO autentica (email nao existe OU senha errada).
    // de proposito a gente nao diz QUAL dos dois falhou - isso e seguranca.

    public Optional<LoginRespostaDTO> login (LoginDTO dto){
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(dto.getEmail());
        if (usuarioEncontrado.isEmpty()){
            return Optional.empty();
        }
        Usuario usuario = usuarioEncontrado.get();
        if(!encoder.matches(dto.getSenha(), usuario.getSenha())){
            return Optional.empty();
        }
        String token = jwtService.gerarToken(usuario.getEmail(), usuario.getNome());
        return Optional.of(new LoginRespostaDTO(token, usuario.getNome()));
    }

    //---------------------------------------------------------------------------------------------


    // --------------------- Exercicio 6 modulo 7.1 -----------------------------------------------

    public List<UsuarioDTO> listarTodos(){
        return usuarioRepository.findAll()
                .stream()
                .map(buscar -> toDto(buscar))
                .toList();
    }
    // --------------------- Desafio modulo 7.1 ------------------------------------------------
    public Optional<UsuarioDTO> desativarUsuario(UsuarioDTO usuarioDTO, Long id) {
        Optional<Usuario> encontrar = usuarioRepository.findById(id);
        if (encontrar.isEmpty()){
            return Optional.empty();
        }

        Usuario usuario = encontrar.get();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setAtivo(usuarioDTO.getAtivo());

        return Optional.of(toDto(usuarioRepository.save(usuario)));
    }
    //-----------------------------------------------------------------------------------------

    public boolean deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)){
            return false;
        }
        usuarioRepository.deleteById(id);
        return true;
    }

    // entidade -> DTO de saida. A senha fica de fora de proposito.
    private UsuarioDTO toDto(Usuario usuario) {
        return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getAtivo());
    }

}
