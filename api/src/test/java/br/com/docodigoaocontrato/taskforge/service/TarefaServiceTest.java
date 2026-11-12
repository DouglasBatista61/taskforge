package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.exception.TarefaNaoEncontradaException;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import br.com.docodigoaocontrato.taskforge.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    // Mudanças aplicadas aqui
    @Test
    void deveDevolverUmaTarefaQuandoOIdExiste() {
        // DADO que o banco "tem" a tarefa 1
        Tarefa tarefa = new Tarefa(1L, "Estudar", 3, false);
        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));

        // QUANDO eu busco a tarefa
        TarefaDTO resultado = tarefaService.buscarTarefaPorId(1L); //Sem optional

        // ENTAO a tarefa é recuperada e convertida em DTO
        assertNotNull(resultado);
        assertEquals("Estudar", resultado.getNome());
        assertEquals(3, resultado.getPrioridade());
        assertFalse(resultado.getConcluida());
    }

    @Test
    void deveDevolverVazioQuandoOIdNaoExiste() {
        // DADO que o banco nao "tem" a tarefa 99
        when(tarefaRepository.findById(99L)).thenReturn(Optional.empty());

        // ENTAO nao vem nenhum resultado
        assertThrows(TarefaNaoEncontradaException.class, () -> tarefaService.buscarTarefaPorId(99L));
    }

    @Test
    void naoDeveApagarQuandoATarefaNaoExiste() {
        // DADO que o banco nao "tem" a tarefa 99
        when(tarefaRepository.existsById(99L)).thenReturn(false);

        // ENTAO a service retorna false
        assertThrows(TarefaNaoEncontradaException.class, () -> tarefaService.deletarTarefa(99L));
        verify(tarefaRepository, never()).deleteById(99L);
        verify(tarefaRepository, only()).existsById(99L);
    }
}
