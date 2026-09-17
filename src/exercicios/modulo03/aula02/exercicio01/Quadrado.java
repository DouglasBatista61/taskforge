package exercicios.modulo03.aula02.exercicio01;

public class Quadrado extends Forma {
    double lado;

    public Quadrado(String nome, double lado) {
        super(nome);
        this.lado = lado;
    }

    @Override
    public double area() {
        return (lado * lado);
    }
}
