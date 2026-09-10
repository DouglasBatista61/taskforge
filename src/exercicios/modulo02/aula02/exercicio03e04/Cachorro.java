package exercicios.modulo02.aula02.exercicio03e04;

public class Cachorro extends Animal {
    public Cachorro (String nome) {
        super(nome);
    }

    @Override
    public void fazerSom() {
        IO.println(nome + ": au au");
    }
}
