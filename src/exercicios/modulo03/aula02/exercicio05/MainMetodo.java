import exercicios.Tarefa;
import exercicios.TarefaSimples;
import exercicios.TarefaStatus;


Tarefa criarTarefa  (String nome, int prioridade){
    return new TarefaSimples(nome, "estudos", prioridade, "Douglas", 8.0, TarefaStatus.EM_ANDAMENTO);
}

void main() {
    List<Tarefa> listaTarefa = new ArrayList<>();
    listaTarefa.add(criarTarefa ("Estudar java", 1));
    listaTarefa.add(criarTarefa("Fazer exercícios", 1));
    IO.println("Total: " + listaTarefa.size());

    for( Tarefa m : listaTarefa){
        IO.println("");
        m.resumo();
    }
}