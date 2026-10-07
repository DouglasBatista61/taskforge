package exercicios.modulo04.aula01.desafio;

// Essa classe que o Spring devolveria o @GetMapping

import java.util.ArrayList;
import java.util.List;


public class Clima {
    private String cidade;
    private double temperaturaC;
    private boolean chovendo;
    private List<PrevisaoDia> previsao;


    public Clima() {
        this.cidade = "Recife";
        this.temperaturaC = 29.4;
        this.chovendo = false;
        this.previsao = new ArrayList<>();
        this.previsao.add(new PrevisaoDia("Segunda", 30.0, 24.5));
        this.previsao.add(new PrevisaoDia("Terça", 31.2, 25.0));
    }

    public String getCidade() {
        return cidade;
    }

    public double getTemperaturaC() {
        return temperaturaC;
    }

    public boolean isChovendo() {
        return chovendo;
    }

    public List<PrevisaoDia> getPrevisao() {
        return previsao;
    }
}
