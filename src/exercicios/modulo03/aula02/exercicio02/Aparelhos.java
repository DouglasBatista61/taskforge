import exercicios.modulo03.aula02.exercicio02.Cadeira;
import exercicios.modulo03.aula02.exercicio02.Ligavel;
import exercicios.modulo03.aula02.exercicio02.Radio;
import exercicios.modulo03.aula02.exercicio02.Tv;

void main() {

    List<Object> aparelhos = new ArrayList<>();
    aparelhos.add(new Tv());
    aparelhos.add(new Radio());
    aparelhos.add(new Cadeira());

    for (Object a : aparelhos) {
        if (a instanceof Ligavel l) {
            IO.println(l.ligar());
        } else {
            IO.println("Não liga");
        }
    }

}