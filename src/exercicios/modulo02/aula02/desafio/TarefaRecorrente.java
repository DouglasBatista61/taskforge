package exercicios.modulo02.aula02.desafio;
import model.*;


public class TarefaRecorrente extends Tarefa implements Notificavel {
    int vezesPorSemana;

    public TarefaRecorrente(int vezesPorSemana) {
        super();
        this.vezesPorSemana = vezesPorSemana;
    }

    @Override
    public String tipo() {
        return "TAREFA RECORRENTE";
    }

    @Override
    public int resumo() {
        return vezesPorSemana;
    }

    @Override
    public String notificar() {
        return "Backup - toda semana ," + vezesPorSemana + " vezes na semana";
    }
}
/* ------------ Bloco que vai no main --------------------
List<Tarefa> listaTarefa = new ArrayList<>();

// Tarefas de exemplo pra ter o que filtrar
    listaTarefa.add(new TarefaSimples("Estudar Java", "Exceções", 1,
        "Douglas", 2,TarefaStatus.EM_ANDAMENTO));
        listaTarefa.add(new TarefaComPrazo("Entregar PR", "Desafio da 3.2", 3,
        "Douglas", 4,TarefaStatus.PENDENTE, 48));
        listaTarefa.add(new TarefaRecorrente(2));

        for (Tarefa t : listaTarefa){
        IO.println("[" + t.tipo() + "] " + t.resumo());
        }

 */