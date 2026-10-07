package exercicios.modulo04.aula01.exerciciosB.exercicioB2;

import java.util.ArrayList;
import java.util.List;

public class PostDTO {
    private int id;
    private String titulo;
    private List<String> tags;
    private boolean publicada;
    private Autor autor;


    public PostDTO() {
        this.id = 15;
        this.titulo = "Aula 4.1";
        this.tags = new ArrayList<>();
        this.tags.add("http");
        this.tags.add("Rest");
        this.tags.add("Json");
        this.publicada = false;
        this.autor = new Autor();
    }

    public int getId() {
        return id;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isPublicada() {
        return publicada;
    }

    public Autor getAutor() {
        return autor;
    }
}

