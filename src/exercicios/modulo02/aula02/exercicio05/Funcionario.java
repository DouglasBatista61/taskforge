package exercicios.modulo02.aula02.exercicio05;

public class Funcionario {
    String nome;
    double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;

    }

    public double salarioAnual() {
        return salario * 12;
    }

    public String getNome() {
        return nome;
    }

}

/* ------------- Bloco na main ----------------
Funcionario ana = new Funcionario("Ana", 3000);
    Gerente bruno = new Gerente("Bruno", 5000, 10000);

    IO.println(ana.getNome() + ": " + ana.salarioAnual());
    IO.println(bruno.getNome() + ": " + bruno.salarioAnual());
 */
