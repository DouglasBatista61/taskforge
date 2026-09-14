// TaskForge - Do Código ao Contrato
// Código final da aula 3.2: EXCEÇÕES + LAMBDAS + STREAMS.
// Agora o programa nao quebra mais na cara do usuario.

import model.Tarefa;
import model.TarefaComPrazo;
import model.TarefaSimples;
import model.TarefaStatus;

import java.util.List;
import java.util.ArrayList;


void main() {
    List<Tarefa> listaTarefa = new ArrayList<>();

    listaTarefa.add(new TarefaComPrazo("Treinar", "Musculação", 2,"Douglas",
            2,TarefaStatus.CONCLUIDA,2));
    listaTarefa.add(new TarefaSimples("Ir ao mercado", "Fazer compras", 2,"Douglas",
            2, TarefaStatus.PENDENTE));
    listaTarefa.add(new TarefaComPrazo("Estudar Java", "Modulo 4", 1, "Douglas",
            8,TarefaStatus.EM_ANDAMENTO, 8));
    listaTarefa.add(new TarefaComPrazo("Entregar PR", "Modulo 3", 1, "Douglas",
            8, TarefaStatus.EM_ANDAMENTO, 8));

    IO.println("Total de tarefas: " + listaTarefa.size());
    for(Tarefa t : listaTarefa){
        IO.println("");
        t.resumo();
    }
}

      /*  List<Tarefa> listaTarefa = new ArrayList<>();

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

List<Tarefa> listaTarefa = new ArrayList<>();

    // Tarefas de exemplo pra ter o que filtrar
    listaTarefa.add(new TarefaSimples("Estudar Java", "Exceções", 1,
            "Douglas", 2, TarefaStatus.EM_ANDAMENTO));
    listaTarefa.add(new TarefaComPrazo("Entregar PR", "Desafio da 3.2", 3,
            "Douglas", 4, TarefaStatus.PENDENTE, 48));
    listaTarefa.add(new TarefaRecorrente(2));

    for (Tarefa t : listaTarefa){
        IO.println("[" + t.tipo() + "] " + t.resumo());
    }

    int opcao = 0;
    do {
        IO.println();
        IO.println("=== TaskForge ===");
        IO.println("1 - Criar tarefa");
        IO.println("2 - Listar tarefas");
        IO.println("3 - Só as pendentes");
        IO.println("4 - Sair");

        // BLOCO 1: o parseInt quebra se o usuario digitar letra.
        // O try/catch e o cinto de seguranca: o programa avisa e CONTINUA.
        try {
            opcao = Integer.parseInt(IO.readln());
        } catch (NumberFormatException e) {
            IO.println("Isso não é um número. Digite de 1 a 4.");
            continue;   // volta pro comeco do laco
        }

        switch (opcao) {
            case 1 -> {
                // BLOCO 2: aqui pode estourar a NOSSA excecao
                try {
                    listaTarefa.add(criarTarefa());
                    IO.println("model.Tarefa criada! Total: " + listaTarefa.size());
                } catch (TarefaInvalidaException e) {
                    // getMessage() traz o texto que a gente escreveu no throw
                    IO.println("Não deu pra criar: " + e.getMessage());
                }
            }
            case 2 -> listar(listaTarefa);
            case 3 -> listarPendentes(listaTarefa);
            case 4 -> IO.println("Até a próxima!");
            default -> IO.println("Opção inválida.");
        }
    } while (opcao != 4);
}

// THROWS: o metodo avisa que PODE estourar. Quem chamar e obrigado a tratar.
Tarefa criarTarefa() throws TarefaInvalidaException {
    String nome = IO.readln("Nome da tarefa: ");

    // THROW: a gente MESMO dispara a excecao quando a regra do negocio e quebrada
    if (nome.isBlank()) {
        throw new TarefaInvalidaException("o nome não pode ficar vazio.");
    }

    int prioridade;
    try {
        prioridade = Integer.parseInt(IO.readln("Prioridade (1 a 5): "));
    } catch (NumberFormatException e) {
        throw new NumberFormatException("a prioridade tem que ser um número.");
    }

    if (prioridade < 1 || prioridade > 5) {
        throw new NumberFormatException("a prioridade tem que estar entre 1 e 5.");
    }

    // AO VIVO a gente para aqui: devolve sempre uma model.TarefaSimples.
    // Deixar o usuario ESCOLHER o tipo (e poder criar uma model.TarefaComPrazo
    // pelo menu, que ai notifica) e o EXTRA do desafio.
    // Por enquanto, a model.TarefaComPrazo do exemplo la em cima e quem mostra
    // o notificar() funcionando na opcao 2.
    return new TarefaSimples(nome, "sem descrição", prioridade,
            "Lander", 2, TarefaStatus.PENDENTE);
}

void listar(List<Tarefa> tarefas) {
    if (tarefas.isEmpty()) {
        IO.println("Nenhuma tarefa cadastrada.");
        return;
    }

    // forEach + LAMBDA: "para cada t, faca..."
    tarefas.forEach(t -> {
        t.resumo();

        // AQUI A INTERFACE TRABALHA:
        // "essa tarefa assinou o contrato model.Notificavel?"
        // A model.TarefaSimples nao assinou -> passa batido, sem erro.
        // A model.TarefaComPrazo assinou -> notifica.
        if (t instanceof Notificavel n) {
            IO.println(n.notificar());
        }
        IO.println("---------------------------");
    });
}

void listarPendentes(List<Tarefa> tarefas) {
    // STREAM: a esteira. filter escolhe, forEach faz.
    // Leia como uma frase: "da lista, FILTRE as pendentes, e pra CADA UMA imprima o nome".
    tarefas.stream()
            .filter(t -> t.getStatus() == TarefaStatus.PENDENTE)
            .forEach(t -> IO.println("- " + t.getNome()));


}

    */