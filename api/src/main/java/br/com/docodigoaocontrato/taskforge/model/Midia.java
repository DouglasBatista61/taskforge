package br.com.docodigoaocontrato.taskforge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Midia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String tipo;
    private Integer duracaoMin;
    private Double avaliacao;
    private Integer anoLancamento;
}

// ------ PASSO 3 DESAFIO ------

//Escreva o SQL que responde cada uma. Uma linha cada.
//1. Só os filmes.
// - SELECT * FROM MIDIA WHERE TIPO = 'FILME';

//2. Tudo com avaliação acima de 8.6, da maior pra menor.
//  - SELECT * FROM MIDIA WHERE AVALIACAO > 8.6 ORDER BY AVALIACAO DESC;

//3. Quantas séries existem no catálogo.
// - SELECT COUNT (*) FROM MIDIA WHERE TIPO = 'SERIE' ;

// ------ PASSO 4 DESAFIO -------

//UPDATE MIDIA SET ANO_LANCAMENTO = 2014 WHERE ID = 1;
//UPDATE MIDIA SET ANO_LANCAMENTO = 2010 WHERE ID = 2;
//UPDATE MIDIA SET ANO_LANCAMENTO = 2017 WHERE ID = 3;
//UPDATE MIDIA SET ANO_LANCAMENTO = 2008 WHERE ID = 4;
