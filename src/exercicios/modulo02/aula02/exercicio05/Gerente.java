package exercicios.modulo02.aula02.exercicio05;

public class Gerente extends Funcionario{
      public double bonusAnual;

      public Gerente(String nome, double salario, double bonusAnual){
          super(nome, salario);
          this.bonusAnual = bonusAnual;
      }

    @Override
    public double salarioAnual() {
          return  (salario * 12) + bonusAnual;
    }
}
