package br.com.docodigoaocontrato.taskforge.exercicios.desafio;

import java.util.List;

public class CatalogoDTO {
    private String nomeDoCatalogo;
    private int total;
    private List<MidiaDTO> midias;

    public CatalogoDTO(String nomeDoCatalogo, List<MidiaDTO> midias) {
        this.nomeDoCatalogo = nomeDoCatalogo;
        this.total = midias.size();
        this.midias = midias;
    }

    public String getNomeDoCatalogo() {
        return nomeDoCatalogo;
    }

    public int getTotal() {
        return total;
    }

    public List<MidiaDTO> getMidias() {
        return midias;
    }
}

