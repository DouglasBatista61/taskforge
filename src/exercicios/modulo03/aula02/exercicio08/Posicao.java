import exercicios.Tarefa;
import exercicios.TarefaComPrazo;
import exercicios.TarefaSimples;
import exercicios.TarefaStatus;

void main() {

    List<Tarefa> posicao = new ArrayList<>();
    posicao.add(new TarefaSimples("Estudar Java", "Exceções", 1,
            "Lander", 2, TarefaStatus.EM_ANDAMENTO));
    posicao.add(new TarefaComPrazo("Entregar PR", "exercicios", 1,"Douglas",
            4, TarefaStatus.EM_ANDAMENTO, 8 ));

    try {
        IO.println(posicao.get(4).getNome());
    }catch (IndexOutOfBoundsException e){
        IO.println("Essa posição não existe. A lista tem " + posicao.size() + " Tarefa(s) (0 a " + (posicao.size() -1)+ ")");
    }
    IO.println("O programa continua");

}