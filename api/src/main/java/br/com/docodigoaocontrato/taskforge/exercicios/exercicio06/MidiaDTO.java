package br.com.docodigoaocontrato.taskforge.exercicios.exercicio06;

public class MidiaDTO {
    String titulo;
    double nota;
    Genero genero;
    int duracaoMin;

    public MidiaDTO(String titulo, double nota, Genero genero, int duracaoMin) {
        this.titulo = titulo;
        this.nota = nota;
        this.duracaoMin = duracaoMin;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getNota() {
        return nota;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getDuracaoMin() {
        return duracaoMin;
    }
}
