void main() {

    try {
        Integer.parseInt(IO.readln("Sua idade: "));
    } catch (NumberFormatException e) {
        IO.println("abc Não é um número válido");
        IO.println("Detalhe técnico: " + e.getMessage());
    }
}