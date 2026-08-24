package exercicios.modulo02.aula01.exercicios;

public class Retangulo {
    private int base;
    private int altura;

    public Retangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }
    public void area(){
        IO.print("Área: ");
        IO.println( base * altura);
    }
    public void perimetro(){
        IO.print("Perímetro: ");
        IO.println( 2 * (base + altura));
    }
}
