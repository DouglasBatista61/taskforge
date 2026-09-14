package exercicios.modulo03.aula01.exercicio02;

public class Cofrinho {
    private double saldo;

    public void depositar (double v){
        if (v > 0){
            saldo += v;
        }else{
            IO.println("Deposito inválido");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

/* ----------- Bloco que vai no main --------------
 Cofrinho c = new Cofrinho();
    c.depositar(50);
    IO.println("Saldo: " + c.getSaldo());
    c.depositar(-1000);
    IO.println("Saldo: " + c.getSaldo());
 */
