package exercicios.modulo02.aula01.exercicios;

public class Livro {

    private String titulo;
    private int paginas;

    public Livro(String titulo, int paginas) {
        this.titulo = titulo;
        this.paginas = paginas;
    }
    public void descrever(){
        IO.println(titulo + " (" + paginas + " págs)");
    }
    public String getTitulo() {
        return titulo;
    }
    public int getPaginas() {
        return paginas;
    }

}
