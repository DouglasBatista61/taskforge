package exercicios.modulo02.aula02.exercicio06;

public class Quadrado extends Forma{
    double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }
}
