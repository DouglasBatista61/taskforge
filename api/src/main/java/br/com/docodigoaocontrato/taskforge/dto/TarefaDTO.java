package br.com.docodigoaocontrato.taskforge.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(accessMode = Schema.AccessMode.READ_ONLY) //---- Exercicio 6 modulo 9.1 -----
    private Long id;
    //-------------- Exercicio 1 modulo 8.1 ---------------------

    @NotBlank(message = "O nome da tarefa é obrigatório")
    @Size(max = 100, message = "Nome da tarefa com máximo de 100 caracteres")
    @Schema(example = "Estudar Spring") //---- Exercicio 6 modulo 9.1 -----
    private String nome;

    // -----------------------------------------------------------
    //-------------- Exercicio 2 modulo 8.1 ---------------------

    @NotNull(message = "Prioridade obrigatória")
    @Min(value = 1, message = "A prioridade deve estar entre 1 e 5")
    @Max(value = 5, message = "A prioridade deve estar entre 1 e 5")
    @Schema(example = "3") //---- Exercicio 6 modulo 9.1 -----
    private Integer prioridade;

    // -----------------------------------------------------------

    private Boolean concluida;



}
