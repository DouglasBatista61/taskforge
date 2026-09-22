package exercicios.modulo03.aula02.exercicio01;

public abstract class Forma {
    private String nome;

    public Forma(String nome) {
        this.nome = nome;
    }

    public abstract double area();

    public void mostrar() {
        IO.println(nome + ": " + area());
    }
}
