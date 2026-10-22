package br.com.docodigoaocontrato.taskforge.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// O formato do JSON que entra e que sai da API.
// A entidade espelha a TABELA; o DTO espelha o JSON.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {

    private Long id;

    @NotBlank(message = "O nome da tarefa é obrigatório")
    @Size(max = 10, message = "Nome da tarefa com máximo de 10 caracteres")
    private String nome;

    @NotNull(message = "Prioridade obrigatória")
    @Min(value = 1, message = "A prioridade deve estar entre 1 e 5")
    @Max(value = 5, message = "A prioridade deve estar entre 1 e 5")
    private int prioridade;
    private boolean concluida;
}
