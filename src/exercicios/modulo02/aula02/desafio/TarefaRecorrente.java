package exercicios.modulo02.aula02.desafio;
import model.Notificavel;
import model.Tarefa;


public class TarefaRecorrente extends Tarefa implements Notificavel {
    int vezesPorSemana;

    public TarefaRecorrente(int vezesPorSemana) {
        super(nome, descricao, prioridade, responsavel, horasEstimadas, status);
        this.vezesPorSemana = vezesPorSemana;
    }

    @Override
    public String tipo() {
        return "TAREFA RECORRENTE";
    }
    @Override
    public String resumo() {
        return "Backup - toda semana, 3x";
    }

    @Override
    public String notificar() {
        return "";
    }
}
