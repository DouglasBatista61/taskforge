package br.com.docodigoaocontrato.taskforge.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @NotBlank(message = "Email obrigatório")
    @Email
    private String email;

    @NotBlank(message = "Digite uma senha")
    private String senha;


}
