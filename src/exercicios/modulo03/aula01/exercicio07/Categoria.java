package exercicios.modulo03.aula01.exercicio07;

public enum Categoria {
    ELETRONICO("Eletrônico"),
    ALIMENTO("Alimento"),
    LIVRO("Livro");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
/* ---------- Esse bloco vai na main ------------------
List<Produto> categoria = new ArrayList<>();
    categoria.add(new Produto("Notebook", Categoria.ELETRONICO));
    categoria.add(new Produto("Arroz", Categoria.ALIMENTO));
    categoria.add(new Produto("Java Fácil", Categoria.LIVRO));

    for ( Produto t : categoria){
        IO.println(t.getNome() + " [" + t.getCategoria().getDescricao() + "]");
    }
 */

