package exercicios.modulo02.aula01.exercicios;

public class Aluno {
    private double ana;
    private String nome;
    private double bruno;

    public Aluno(double ana, double bruno) {
        this.ana = ana;
        this.bruno = bruno;
    }

    public void media(){
        IO.print("Ana: ");
        IO.println(ana);
        IO.print("Bruno: ");
        IO.println(bruno);
    }
}
