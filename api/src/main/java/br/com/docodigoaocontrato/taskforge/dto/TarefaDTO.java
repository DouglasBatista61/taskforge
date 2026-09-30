package br.com.docodigoaocontrato.taskforge.dto;

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
    private String nome;
    private int prioridade;
    private boolean concluida;
}
