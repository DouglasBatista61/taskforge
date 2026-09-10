package exercicios.modulo01.aula02;

public class Desafio {
    void main() {
        IO.println("=== TaskForge v0 ===");
        IO.println("");

        int totalTarefas = 0;
        boolean menu = true;
        while(menu){
            IO.println("Escolha uma das opçoes: ");
            IO.println("1 - Criar tarefa, 2 - Ver resumo, 3 - Sair");
            int opcao = Integer.parseInt(IO.readln("Opção : "));
            switch (opcao){
                case 1 -> {
                    String nome = IO.readln("Nome da tarefa: ");
                    String descricao = IO.readln("Descrição: ");
                    int prioridade = Integer.parseInt(IO.readln("Prioridade (1 a 5): "));
                    if(prioridade < 1 || prioridade > 5){
                        IO.println("prioridade invalida");
                        prioridade = Integer.parseInt(IO.readln("Prioridade (1 a 5): "));
                    }
                    double horasEstimadas = Double.parseDouble(IO.readln("Horas estimadas: "));
                    String responsavel = IO.readln("Responsável: ");
                    String status = IO.readln("Status: ");

                    IO.println("");
                    IO.println("------ TAREFA CRIADA ------");
                    IO.println("model.Tarefa:     " + nome);
                    IO.println("Descrição:  " + descricao);
                    IO.print("Prioridade: ");
                    for(int i = 0; i < prioridade; i++){
                        IO.print("*");
                    }
                    IO.println("");
                    IO.println("Horas estimadas: " + horasEstimadas);
                    IO.println("Responsavel: " + responsavel);
                    IO.println("Status: " + status);
                    IO.println("---------------------------");

                    totalTarefas ++;

                }
                case 2 -> IO.println("Você realizou " + totalTarefas + " tarefa(s)");
                case 3 -> {
                    IO.println("Saindo do taskforge...");
                    menu = false;
                }
                default -> IO.println("Opção inválida");
            }
            IO.println("");
        }
    }
}
