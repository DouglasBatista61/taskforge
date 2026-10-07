package br.com.docodigoaocontrato.taskforge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MidiaDTO {

    private Long id;
    private String tipo;
    private String titulo;
    private Integer duracaoMin;
    private Double avaliacao;
    private Integer anoLancamento;

}
