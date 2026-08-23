// TaskForge v0 - Do Código ao Contrato
// Código final da aula 1.2: entrada validada, status e cartão da tarefa.

void main() {
    IO.println("=== TaskForge v0 ===");

    String nome = IO.readln("Nome da tarefa: ");
    String descricao = IO.readln("Descrição: ");
    int prioridade = Integer.parseInt(IO.readln("Prioridade (1 a 5): "));
    double horasEstimadas = Double.parseDouble(IO.readln("Horas estimadas: "));
    String responsavel = IO.readln("Responsável: ");
    String status = IO.readln("Status: ");


    IO.println("");
    IO.println("------ TAREFA CRIADA ------");
    IO.println("Tarefa:     " + nome);
    IO.println("Descrição:  " + descricao);
    IO.println("Prioridade: " + prioridade);
    IO.println("Horas estimadas: " + horasEstimadas);
    IO.println("Responsavel: " + responsavel);
    IO.println("Status: " + status);
    IO.println("---------------------------");
}