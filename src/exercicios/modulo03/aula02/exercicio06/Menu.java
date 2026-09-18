void main() {

    int opcao = 0;

    do {
        IO.println("1 - Teste");
        IO.println("2 - Teste");
        IO.println("3 - Sair");

        String entrada = IO.readln();
        try {
            opcao = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            IO.println("[" + entrada + "] não é número. Tente de novo.");
            IO.println("");
            continue;
        }
        switch (opcao) {
            case 1 -> IO.println("Opção 1 escolhida.");
            case 2 -> IO.println("Opção 2 escolhida.");
            case 3 -> IO.println("Até logo");
            default -> IO.println("Opção invalida");
        }

    } while (opcao != 3);
}