package exercicios.modulo04.aula01.exerciciosB.exercicioB2;

public class Autor {
    private String nome;
    private String email;

    public Autor() {
        this.nome = "Lander";
        this.email = "Lander@gmail.com";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
