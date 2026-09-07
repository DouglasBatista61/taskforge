package exercicios.modulo02.aula02.exercicio03e04;

public class Gato extends Animal {

    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void fazerSom() {
        IO.println(nome + ": Miau");
    }
}
