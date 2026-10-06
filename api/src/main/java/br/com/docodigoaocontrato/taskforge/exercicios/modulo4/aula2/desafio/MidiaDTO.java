package br.com.docodigoaocontrato.taskforge.exercicios.modulo4.aula2.desafio;

import br.com.docodigoaocontrato.taskforge.exercicios.modulo4.aula2.exercicio06.Genero;

public class MidiaDTO {
    private String titulo;
    private double nota;
    private Genero genero;
    private int duracaoMin;

    public MidiaDTO(String titulo, double nota, Genero genero, int duracaoMin) {
        this.titulo = titulo;
        this.nota = nota;
        this.duracaoMin = duracaoMin;
        this.genero = genero;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public double getNota() {
        return this.nota;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public int getDuracaoMin() {
        return this.duracaoMin;
    }
}

