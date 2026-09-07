package exercicios.modulo02.aula02.exercicio02;

 public enum Semaforo {
     VERMELHO,
     AMARELO,
     VERDE;

     static String acao(Semaforo s) {
         return switch (s) {
             case VERMELHO -> "Pare";
             case AMARELO -> "Atenção";
             case VERDE -> "Siga";
         };
     }
 }
 // ------------- Esse bloco vai no Main -------------
 // IO.println(acao(Semaforo.VERDE));

