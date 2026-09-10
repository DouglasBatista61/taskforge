package exercicios.modulo02.aula02.exercicio03e04;

public class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }
    public void fazerSom(){
        IO.println(nome + ": ...");
    }
}
/*
---------------- Esse bloco vai no Main ----------------
-----Exercicio 3-----

Cachorro c = new Cachorro("Rex");
    c.fazerSom();
Gato g = new Gato("Max");
    g.fazerSom();

---- Exercicio 4 ---
Animal[] animais = { new Cachorro("Rex"), new Gato("Mimi") };
    for (Animal a: animais){
        a.fazerSom();
    } */