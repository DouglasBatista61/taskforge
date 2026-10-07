void main() {
    int a = 10;
    int b = 0;

    try {
        IO.println(a / b);
    } catch (ArithmeticException e) {
        IO.println("Não da pra dividir por zero!");
    }
    IO.println("O programa continua vivo.");


}