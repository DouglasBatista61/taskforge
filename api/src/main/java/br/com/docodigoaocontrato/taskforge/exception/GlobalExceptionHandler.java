package br.com.docodigoaocontrato.taskforge.exception;

import br.com.docodigoaocontrato.taskforge.dto.ErroResposta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // ------------------------ Exercício 6 modulo 8.1 ------------------------------------

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> tratarValidacao(MethodArgumentNotValidException ex){
        Map<String, String> campos = new LinkedHashMap<>();
        for (FieldError erro : ex.getFieldErrors()){
            campos.put(erro.getField(), erro.getDefaultMessage());
        }
        ErroResposta resposta = new ErroResposta(400, "Dados inválidos", campos);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }
    //------------------------------------------------------------------------------------

    // ------------------------ Exercício 7 modulo 8.1 ------------------------------------

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResposta> tratarJsonInvalido(HttpMessageNotReadableException ex){
        ErroResposta resposta = new ErroResposta(400, "Json inválido, confira a estrutura", Map.of());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }
    //------------------------------------------------------------------------------------

    // ------------------------ Desafio modulo 8.1 ------------------------------------

    @ExceptionHandler(TarefaNaoEncontradaException.class)
    public ResponseEntity<ErroResposta> tarefaNaoEncontrada(TarefaNaoEncontradaException ex){
        ErroResposta resposta = new ErroResposta(404, ex.getMessage(), Map.of());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
    }
}
