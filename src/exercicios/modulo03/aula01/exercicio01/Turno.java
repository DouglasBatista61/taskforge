package exercicios.modulo03.aula01.exercicio01;

public enum Turno {
    MANHA ("Manhã"),
    TARDE ("Tarde"),
    NOITE ("Noite");

    private final String descrição;

    Turno(String descrição) {
        this.descrição = descrição;
    }

    public String getDescrição() {
        return descrição;
    }
}

/* ------- Bloco que vai no main --------
 Turno t = Turno.TARDE;
    IO.println(t.getDescrição());
    IO.println(t);
 */
