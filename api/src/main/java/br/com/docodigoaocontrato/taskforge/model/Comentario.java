package br.com.docodigoaocontrato.taskforge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private String descricao;
    private LocalDateTime dataCriacao;

    @PrePersist
    public void aoCriar() {
        this.dataCriacao = LocalDateTime.now();
    }

    public Comentario(Long id, @NotBlank(message = "A Descrição não pode ser em branco") @Size(max = 500) String descricao, @NotBlank(message = "Informe o autor") @Size(max = 100) String autor) {
        this.id = id;
        this.descricao = descricao;
        this.autor = autor;
    }
}
