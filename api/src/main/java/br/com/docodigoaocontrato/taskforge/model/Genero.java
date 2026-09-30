package br.com.docodigoaocontrato.taskforge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

}


// ---- QUESTIONAMENTO -----
// Depois pense e escreva — só pensar, não codar: como você ligaria uma mídia ao gênero dela?

// Eu tenho mais ou menos uma ideia, sei que teria que ter uma relaciomento entre as duas tabela,
// colocando um foreign key da tabela midia. agora so não como seria codado isso.


