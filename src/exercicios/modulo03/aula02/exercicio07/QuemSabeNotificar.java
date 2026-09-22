import exercicios.*;

void main() {

    List<Tarefa> notificar = new ArrayList<>();
    notificar.add(new TarefaSimples("Estudar Java", "Exceções", 1,
            "Lander", 2, TarefaStatus.EM_ANDAMENTO));
    notificar.add(new TarefaComPrazo("Entregar PR", "exercicios", 1,"Douglas",
            4, TarefaStatus.EM_ANDAMENTO, 8 ));
    notificar.add(new TarefaSimples("Ler apostila", "Try catch", 1,
            "Lander", 2, TarefaStatus.EM_ANDAMENTO));

    for(Tarefa n: notificar){
        IO.println("- " + n.getNome());
        if(n instanceof Notificavel a){
           IO.println("  " + a.notificar());
        }
    }
    
}