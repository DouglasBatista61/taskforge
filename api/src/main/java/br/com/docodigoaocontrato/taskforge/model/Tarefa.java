package br.com.docodigoaocontrato.taskforge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer prioridade;
    private Boolean concluida;
    private LocalDateTime dataCriacao;

    @PrePersist
    public void aoCriar() {
        this.dataCriacao = LocalDateTime.now();
    }

    // Gerado no IntelliJ na 6.1 (Generate > Constructor), SEM o id:
    // quem numera a tarefa e o banco. E o que o toEntity usa.
    public Tarefa(String nome, Integer prioridade, Boolean concluida) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.concluida = concluida;
    }
    public Tarefa(Long id, String nome, Integer prioridade, Boolean concluida) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.concluida = concluida;
    }

}


