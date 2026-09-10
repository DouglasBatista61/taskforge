package exercicios.modulo02.aula01.desafio;

public class TarefaDesafio {
    private String nome;
    private String descricao;
    private int prioridade;
    private String responsavel;
    private double horasEstimadas;
    private int status;

    public TarefaDesafio(String nome, String descricao, int prioridade, String responsavel, double horasEstimadas, int status) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.responsavel = responsavel;
        this.horasEstimadas = horasEstimadas;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public double getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(double horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public void imprimirCartao(){
        IO.println(nome);
        IO.println(descricao);
        IO.print("Prioridade: ");
        for (int aux = 0; aux < prioridade; aux++) {
            IO.print("*");
        }
        IO.println("");
        IO.println(responsavel);
        IO.println(horasEstimadas);

        String statusNome = "";
        switch (status) {
            case 1 -> statusNome = "Pendente";
            case 2 -> statusNome = "Em Andamento";
            case 3 -> statusNome = "Concluída";
            case 4 -> statusNome = "Cancelada";
            default -> statusNome = "Status Inválido";
        }

        IO.println("Status: " + statusNome);

        IO.println("");
    }
}
