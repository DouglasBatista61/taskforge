package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.*;
import br.com.docodigoaocontrato.taskforge.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")   // cadastro = POST /usuarios ; login = POST /usuarios/login
@Tag(name = "Usuarios", description = "Cadastro e login (rotas publicas)")
@SecurityRequirements // Essas rotas não precisam de token.
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // ---- 7.1: cadastro ----  POST /usuarios
    // -------- Exercicio 3 modulo 8.1 ----------------------- @valid
    @Operation(summary = " Cadastra um novo usuário")
    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@Valid @RequestBody UsuarioCadastroDTO dto) {
        Optional<UsuarioDTO> criado = usuarioService.cadastrar(dto);
        if (criado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(criado.get());
    }


    // ---- 7.2: login ----  POST /usuarios/login
    // -------- Exercicio 3 modulo 8.1 ----------------------- @valid
    @Operation(summary = " Login de usuário")
    @PostMapping("/login")
    public ResponseEntity<LoginRespostaDTO> login(@Valid @RequestBody LoginDTO dto) {
        Optional<LoginRespostaDTO> token = usuarioService.login(dto);
        if (token.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(token.get());
    }

    // --------------------- Exercicio 6 modulo 7.1 --------------------------------------
    @Operation(summary = " Lista todos os usuários")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodos(@RequestParam(required = false) Boolean ativo) {
        return ResponseEntity.ok(usuarioService.listarTodos(ativo));
    }
    // ------------------------------------------------------------------------------------

    // --------------------- Desafio modulo 7.1 -------------------------------------------
    @Operation(summary = " Atualiza um usuário")
    @PutMapping("/{id}/desativar")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Optional<UsuarioDTO> atualizado = usuarioService.desativarUsuario(usuarioDTO, id);
        if (atualizado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizado.get());
    }

    // ------------------------------------------------------------------------------------
    @Operation(summary = " Deleta um usuário")
    @DeleteMapping
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        if (!usuarioService.deletarUsuario(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}


