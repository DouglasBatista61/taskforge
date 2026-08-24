package src;

public class Tarefa {
    private String nome;
    private String descricao;
    private int prioridade;
    private String responsavel;
    private double horasEstimadas;
    private int status;
    private String statusNome;

    public Tarefa(String nome, String descricao, int prioridade, String responsavel, double horasEstimadas, int status, String statusNome) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.responsavel = responsavel;
        this.horasEstimadas = horasEstimadas;
        this.status = status;
        this.statusNome = statusNome;
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

    public String getStatusNome() {
        return statusNome;
    }

    public void setStatusNome(String statusNome) {
        this.statusNome = statusNome;
    }
}
