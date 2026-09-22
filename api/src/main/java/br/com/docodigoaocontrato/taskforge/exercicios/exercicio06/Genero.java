package br.com.docodigoaocontrato.taskforge.exercicios.exercicio06;

public enum Genero {
    ACAO("Açao"), TECNOLOGIA("Tecnologia"), COMEDIA("Comedia"), FICCAO_CIENTIFICA("Ficção Científica");

    private final String descrição;


    Genero(String descrição) {
        this.descrição = descrição;
    }

    public String getDescrição() {
        return descrição;
    }
}
;