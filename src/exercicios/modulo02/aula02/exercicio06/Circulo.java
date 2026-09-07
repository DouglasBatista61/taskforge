package exercicios.modulo02.aula02.exercicio06;

public class Circulo extends Forma {
    double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return 3.14 * raio * raio;
    }
}
