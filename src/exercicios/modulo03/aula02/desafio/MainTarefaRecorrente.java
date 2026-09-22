import exercicios.Tarefa;
import exercicios.TarefaComPrazo;
import exercicios.TarefaSimples;
import exercicios.TarefaStatus;
import exercicios.modulo03.aula02.desafio.TarefaRecorrente;

void main() {
    List<Tarefa> listatarefas = new ArrayList<>();

    listatarefas.add(new TarefaSimples("Estudar java", "try catch", 1, "Douglas",
            4, TarefaStatus.EM_ANDAMENTO));
    listatarefas.add(new TarefaComPrazo("Treinar", "musculação", 2, "Douglas",
            2, TarefaStatus.PENDENTE, 2));
    listatarefas.add(new TarefaRecorrente("Correr", "Correr 3 a 5 kms", 2, "Douglas",
            0.30, TarefaStatus.PENDENTE, 2));

    int opcao = 0;

    do {
        IO.println("");
        IO.println("1 - listar todas as tarefas");
        IO.println("2 - Listar pendentes");
        IO.println("3 - Sair");
        IO.println("");

        try {
            opcao = Integer.parseInt(IO.readln());
        } catch (NumberFormatException e) {
            IO.println("Isso não é um número. Digite de 1 a 3.");
            continue;
        }

        switch (opcao) {
            case 1 -> {
                for (Tarefa r : listatarefas) {
                    IO.println("------------------------");
                    r.resumo();
                }
            }
            case 2 -> {
                for (Tarefa p : listatarefas) {
                    if (p.getStatus() == TarefaStatus.PENDENTE) {
                        IO.println("A tarefa: " + p.getNome() + " em " + p.tipo() + ", esta pendente");
                    }
                }
            }
            case 3 -> IO.println("Até logo!");
            default -> IO.println("Opção inválida!");
        }
    } while (opcao != 3);
}