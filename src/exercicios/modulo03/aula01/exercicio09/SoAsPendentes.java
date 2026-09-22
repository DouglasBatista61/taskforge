import exercicios.Tarefa;
import exercicios.TarefaComPrazo;
import exercicios.TarefaSimples;
import exercicios.TarefaStatus;

void main() {
    List<Tarefa> listaTarefa = new ArrayList<>();

    listaTarefa.add(new TarefaSimples("Estudar Java", "Listas", 1,
            "Douglas", 4, TarefaStatus.PENDENTE));
    listaTarefa.add(new TarefaSimples("Entregar PR", "Modulo 3", 1,
            "Douglas", 8, TarefaStatus.PENDENTE));
    listaTarefa.add(new TarefaComPrazo("Exercicios de fixação", "Conteudo do modulo 3", 1,
            "Douglas", 2, TarefaStatus.EM_ANDAMENTO, 2));
    listaTarefa.add(new TarefaComPrazo("Treinar", "Musculação", 2,
            "Douglas", 2, TarefaStatus.CONCLUIDA, 2));

    IO.println("Total de tarefas: " + listaTarefa.size());

    List<Tarefa> concluidas = new ArrayList<>();
    for (Tarefa t : listaTarefa) {
        if (t.getStatus() == TarefaStatus.CONCLUIDA) {
            concluidas.add(t);
        }
    }
    IO.println("Concluidas encontradas: " + concluidas.size());

    listaTarefa.removeAll(concluidas);

    IO.println("Sobraram: " + listaTarefa.size());

    for (Tarefa r : listaTarefa) {
        IO.println("");
        r.resumo();
    }
}
