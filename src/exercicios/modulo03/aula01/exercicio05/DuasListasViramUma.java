void main() {
    List<String> manha = new ArrayList<>();
    manha.add("Ana");
    manha.add("Bruno");

    List<String> tarde = new ArrayList<>();
    tarde.add("Carla");
    tarde.add("Diego");
    tarde.add("Elis");

    IO.println("Manhã: " + manha.size() + " | " + "Tarde: " + tarde.size());

    manha.addAll(tarde);
    IO.println("Depois do addAll -> Manhã: " + manha.size());
    for (String nomes : manha) {
        IO.println("- " + nomes);
    }
    IO.println("Tarde continua com: " + tarde.size());
}
