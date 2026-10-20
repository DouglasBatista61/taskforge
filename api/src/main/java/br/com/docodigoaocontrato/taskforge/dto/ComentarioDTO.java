package br.com.docodigoaocontrato.taskforge.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioDTO {

    private Long id;

    @NotBlank(message = "A Descrição não pode ser em branco")
    @Size(max = 255)
    private String descricao;

    @NotBlank(message = "Informe o autor")
    @Size(max = 100)
    private String autor;
}
