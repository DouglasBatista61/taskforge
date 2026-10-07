package exercicios.modulo04.aula01.desafio;

import java.util.List;

public class PrevisaoDia {
    private String dia;
    private double maxC;
    private double minC;

    public PrevisaoDia(String dia, double maxC, double minC) {
        this.dia = dia;
        this.maxC = maxC;
        this.minC = minC;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public double getMaxC() {
        return maxC;
    }

    public void setMaxC(double maxC) {
        this.maxC = maxC;
    }

    public double getMinC() {
        return minC;
    }

    public void setMinC(double minC) {
        this.minC = minC;
    }
}
