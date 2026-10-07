import exercicios.modulo03.aula02.exercicio01.Circulo;
import exercicios.modulo03.aula02.exercicio01.Forma;
import exercicios.modulo03.aula02.exercicio01.Quadrado;

void main() {
    List<Forma> formas = new ArrayList<>();
    formas.add(new Circulo("Circulo", 2));
    formas.add(new Quadrado("Quadrado", 3));

    for (Forma f : formas) {
        f.mostrar();
    }
    // Forma teste = new Forma("teste"); // Erro causando pq forma é um abstract portando não receber new.

}
