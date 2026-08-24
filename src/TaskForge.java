// TaskForge v0 - Do Código ao Contrato
// Código final da aula 1.2: entrada validada, status e cartão da tarefa.

import exercicios.modulo02.aula01.desafio.Tarefa;
import exercicios.modulo02.aula01.exercicios.Aluno;
import exercicios.modulo02.aula01.exercicios.ContaBancaria;
import exercicios.modulo02.aula01.exercicios.Livro;
import exercicios.modulo02.aula01.exercicios.Retangulo;

void main() {
    IO.println("=== TaskForge v0 ===");

    // (-------------------------------- Desafio ----------------------------------)
    Tarefa desafio = new Tarefa("Estudar", "Java", 1, "Douglas", 4.0, 1);
    Tarefa desafio2 = new Tarefa("Desafio", "React", 2, "Outro", 5.0, 2);
    desafio.imprimirCartao();
    IO.println("");
    desafio2.imprimirCartao();

    /* (------------------- Conta bancaria(Incompleto) ---------)
    ContaBancaria c = new ContaBancaria("Ana", 0);

    (-----------------------Boletim aluno---------------------)
    Aluno m = new Aluno(7.5, 9.0);
    m.media();


    (------------------------Retangulo -----------------------)
    Retangulo r = new Retangulo(4, 3);
    r.area();
    r.perimetro();

    (------------------------- Livro -------------------------)
    Livro l = new Livro("Java Fácil", 200);
    IO.println(l.getTitulo() + " tem " + l.getPaginas() + " páginas");

    l.descrever();

    IO.println(l.getTitulo());
    (----------------------- Codigo aula 2.1 -----------------------------------)

    Tarefa tarefa = new Tarefa("Nome Tarefa", "Descrição Tarefa", 1, "Douglas",
            1.0,  2, "Em andamento" );

    Tarefa tarefa2 = new Tarefa("Estudar", "Java", 1, "Douglas",
            3.0,  2, "Em andamento" );

    IO.println("A tarefa foi criada: " + tarefa.getNome());
    IO.println("Nova tarefa criada: " + tarefa2.getNome());

   (-------------------- Codigo original ------------------------)

    String nome = IO.readln("Nome da tarefa: ");
    String descricao = IO.readln("Descrição: ");

    int prioridade = 0;
    do {
        prioridade = Integer.parseInt(IO.readln("Prioridade (1 a 5): "));
        if (prioridade < 1 || prioridade > 5) {
            IO.println("Prioridade inválida.");
        }
    } while (prioridade < 1 || prioridade > 5);

    IO.println();
    String responsavel = IO.readln("Responsável: ");
    double horasEstimadas = Double.parseDouble(IO.readln("Horas estimadas: "));

    int status;
    do {
        IO.println("Escolha uma opção: ");
        IO.println("1 - Pendente");
        IO.println("2 - Em Andamento");
        IO.println("3 - Concluída");
        IO.println("4 - Cancelada");
        status = Integer.parseInt(IO.readln());
        if (status < 1 || status > 4) {
            IO.println("Status inválido.");
        }
    } while (status < 1 || status > 4);

    IO.println("");
    IO.println("------ TAREFA CRIADA ------");
    IO.println("Tarefa:     " + nome);
    IO.println("Descrição:  " + descricao);
    IO.print("Prioridade: ");
    for (int aux = 0; aux < prioridade; aux++) {
        IO.print("*");
    }
    IO.println();

    String statusNome = "";
    switch (status) {
        case 1 -> statusNome = "Pendente";
        case 2 -> statusNome = "Em Andamento";
        case 3 -> statusNome = "Concluída";
        case 4 -> statusNome = "Cancelada";
        default -> statusNome = "Status Inválido";
    }

    IO.println("Status:    " + statusNome);
    IO.println("---------------------------"); */
}