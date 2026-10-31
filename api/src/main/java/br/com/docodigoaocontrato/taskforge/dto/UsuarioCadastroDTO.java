package br.com.docodigoaocontrato.taskforge.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO de ENTRADA do cadastro. A senha ENTRA aqui (so na entrada), e nunca sai.
// Por isso ele e separado do UsuarioDTO (a saida): um campo que entra mas nao sai
// e exatamente onde o "DTO unico" nao da mais conta.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCadastroDTO {

    // ---------------- Exercicio 3 modulo 8.1 ---------------------------------
    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email está inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve conter pelo menos 6 caracteres")
    private String senha;


}
