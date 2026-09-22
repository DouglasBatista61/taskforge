import exercicios.Tarefa;
import exercicios.TarefaComPrazo;
import exercicios.TarefaSimples;
import exercicios.TarefaStatus;

void main() {
    List<Tarefa> listaTarefa = new ArrayList<>();

    listaTarefa.add(new TarefaComPrazo("Treinar", "Musculação", 2, "Douglas",
            2, TarefaStatus.CONCLUIDA, 2));
    listaTarefa.add(new TarefaSimples("Ir ao mercado", "Fazer compras", 2, "Douglas",
            2, TarefaStatus.PENDENTE));
    listaTarefa.add(new TarefaComPrazo("Estudar Java", "Modulo 4", 1, "Douglas",
            8, TarefaStatus.EM_ANDAMENTO, 8));
    listaTarefa.add(new TarefaComPrazo("Entregar PR", "Modulo 3", 1, "Douglas",
            8, TarefaStatus.EM_ANDAMENTO, 8));

    IO.println("Total de tarefa(s): " + listaTarefa.size());
    for (Tarefa t : listaTarefa) {
        IO.println("");
        t.resumo();
    }
    IO.println("");
    IO.println("Imprimindo tarefa na posição 0: " + listaTarefa.get(0).getNome());
    IO.println("Imprimindo tarefa na ultima posição: " + listaTarefa.get(listaTarefa.size() -1).getNome());

    listaTarefa.remove(0);
    IO.println("Uma tarefa removida pela posição, restam: " + listaTarefa.size() + " Tarefas");

    Tarefa alvo = listaTarefa.get(0);
    listaTarefa.remove(alvo);
    IO.println("Uma tarefa removida pelo objeto, restam: " + listaTarefa.size() + " Tarefas");

    List<Tarefa> backlog = new ArrayList<>();
    backlog.add(new TarefaSimples("Beber agua", "Tomar 200ml", 1, "Douglas",
            0.30, TarefaStatus.EM_ANDAMENTO));
    backlog.add(new TarefaComPrazo("Pagar contas", "Contas mensais", 1, "Douglas",
            0, TarefaStatus.CONCLUIDA, 0));
    listaTarefa.addAll(backlog);

    IO.println("Adicionando a lista backlog á listaTarefa, total de tarefas: " + listaTarefa.size());

    List<Tarefa> concluidas = new ArrayList<>();
    for (Tarefa c : listaTarefa) {
        if (c.getStatus() == TarefaStatus.CONCLUIDA) {
            concluidas.add(c);
        }
    }
    IO.println("Concluida(s): " + concluidas.size() + " Tarefa(s)");

    listaTarefa.removeAll(concluidas);
    IO.println("Depois de remover as concluidas restaram: " + listaTarefa.size() + " Tarefas");

    int pendente = 0;
    int concluida = 0;
    int andamento = 0;
    int cancelada = 0;

    for (Tarefa x : listaTarefa) {
        if (x.getStatus() == TarefaStatus.PENDENTE) {
            pendente++;
        } else if (x.getStatus() == TarefaStatus.CONCLUIDA) {
            concluida++;
        } else if (x.getStatus() == TarefaStatus.EM_ANDAMENTO) {
            andamento++;
        } else {
            cancelada++;
        }
    }
    IO.println("Tarefa(s) pendente(s): " + pendente);
    IO.println("Tarefa(s) concluida(s): " + concluida);
    IO.println("Tarefa(s) andamento(s): " + andamento);
    IO.println("Tarefa(s) cancelada(s): " + cancelada);
}



