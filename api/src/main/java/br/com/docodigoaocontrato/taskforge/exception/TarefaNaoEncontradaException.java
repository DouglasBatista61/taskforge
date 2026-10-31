package br.com.docodigoaocontrato.taskforge.exception;

// ------------------Desafio modulo 8.1 -------------------------------------------------

public class TarefaNaoEncontradaException extends RuntimeException{

    public TarefaNaoEncontradaException(Long id) {
        super("Tarefa " + id + " não encontrada");
    }
}
