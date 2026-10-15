package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.LoginDTO;
import br.com.docodigoaocontrato.taskforge.dto.TokenDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioCadastroDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
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

    // as duas ferramentas sao INSTANCIADAS com new (nao injetadas), igual o padrao da 7.1.
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final JwtService jwtService = new JwtService();


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // ---- 7.1: cadastro ----
    public Optional<UsuarioDTO> cadastrar(UsuarioCadastroDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            return Optional.empty();
        }
        String senhaCriptografada = encoder.encode(dto.getSenha());
        Usuario usuario = new Usuario(dto.getNome(), dto.getEmail(), senhaCriptografada);
        return Optional.of(toDto(usuarioRepository.save(usuario)));
    }

    // ---- 7.2: login ----
    // devolve vazio quando NAO autentica (email nao existe OU senha errada).
    // de proposito a gente nao diz QUAL dos dois falhou - isso e seguranca.
    public Optional<TokenDTO> login(LoginDTO dto) {
        Optional<Usuario> encontrado = usuarioRepository.findByEmail(dto.getEmail());
        if (encontrado.isEmpty()) {
            return Optional.empty();                 // email nao existe
        }
        Usuario usuario = encontrado.get();
        // matches: embaralha a senha digitada e compara com o hash salvo.
        if (!encoder.matches(dto.getSenha(), usuario.getSenha())) {
            return Optional.empty();                 // senha errada
        }
        String token = jwtService.gerarToken(usuario.getEmail());
        return Optional.of(new TokenDTO(token));
    }

    // --------------------- Exercicio 6 modulo 7.1 --------------------------------------

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

    // entidade -> DTO de saida. A senha fica de fora de proposito.
    private UsuarioDTO toDto(Usuario u) {
        return new UsuarioDTO(u.getId(), u.getNome(), u.getEmail(), u.getAtivo());
    }


}
