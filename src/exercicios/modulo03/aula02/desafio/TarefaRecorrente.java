package exercicios.modulo03.aula02.desafio;

import exercicios.Tarefa;
import exercicios.TarefaStatus;

public class TarefaRecorrente extends Tarefa {
    int diasIntervalo;

    public TarefaRecorrente(String nome, String descricao, int prioridade, String responsavel,
                            double horasEstimadas, TarefaStatus status, int diasIntervalo) {
        super(nome, descricao, prioridade, responsavel, horasEstimadas, status);
        this.diasIntervalo = diasIntervalo;
    }

    @Override
    public String tipo() {
        return "Tarefa recorrente";
    }

    @Override
    public int resumo() {
        super.resumo();
        IO.println("Essa tarefa se repete a cada: " + diasIntervalo + " dias");
        return 0;
    }
}
