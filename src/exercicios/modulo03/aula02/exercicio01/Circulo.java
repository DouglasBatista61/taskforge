package exercicios.modulo03.aula02.exercicio01;

public class Circulo extends Forma {
    double raio;

    public Circulo(String nome, double raio) {
        super(nome);
        this.raio = raio;
    }

    @Override
    public double area() {
        return (3.14 * raio * raio);
    }
}
