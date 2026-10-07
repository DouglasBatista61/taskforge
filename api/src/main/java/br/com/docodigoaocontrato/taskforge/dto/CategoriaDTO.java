package br.com.docodigoaocontrato.taskforge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

     private Long id;
     private String nome;
     private Boolean ativa;

     public CategoriaDTO(String nome, Boolean ativa) {
     }
}
