package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.exception.TarefaNaoEncontradaException;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import br.com.docodigoaocontrato.taskforge.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    // MUDOU · GET /tarefas e GET /tarefas?concluida=true
    // A decisao de "filtrar ou nao" e regra: mora aqui, nao na controller.
    public List<TarefaDTO> buscarTodos(Boolean concluida) {
        List<Tarefa> tarefas;
        if (concluida == null) {
            tarefas = tarefaRepository.findAll();
        } else {
            tarefas = tarefaRepository.findByConcluida(concluida);
        }
        return tarefas.stream()
                .map(tarefa -> toDto(tarefa))
                .toList();
    }

    // --------------- Exercicio 5 modulo 5.2 -----------------------------------------------

    public List<TarefaDTO> buscarPendentes(Boolean concluida){
        List<Tarefa> tarefasPendentes;
        if (concluida == null){
            tarefasPendentes = tarefaRepository.findByConcluida(false);
        }else {
            tarefasPendentes = tarefaRepository.findByConcluida(concluida);
        }
        return tarefasPendentes.stream()
                .map(tarefaPendente -> toDto(tarefaPendente))
                .toList();
    }

    // --------------------------------------------------------------------------------------

    // -------------------------- Exercicio 6 modulo 5.2 ------------------------------------

    public List<TarefaDTO> buscarUrgentes(Integer prioridade, Boolean concluida){
        List<Tarefa> tarefasUrgentes;
        tarefasUrgentes = tarefaRepository.findByPrioridadeAndConcluida(3, false);

        return tarefasUrgentes.stream()
                .map(tarefaUrgente -> toDto(tarefaUrgente))
                .toList();
    }

    // --------------------------------------------------------------------------------------


    // NOVO · GET /tarefas/{id}
    // Optional = a caixa que pode vir vazia. A Service NAO sabe o que e 404.
    // ------------------Desafio modulo 8.1 -------------------------------------------------

    public TarefaDTO buscarTarefaPorId(Long id) {
        return tarefaRepository.findById(id)
                .map(tarefa -> toDto(tarefa))
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }
    // --------------------------------------------------------------------------------------

    public TarefaDTO criarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = toEntity(tarefaDTO);
        return toDto(tarefaRepository.save(tarefa));
    }

    // NOVO · PUT /tarefas/{id}
    // Primeiro busca. Se nao existe, a caixa volta vazia.
    // O id vem da URL, nunca do JSON.

    // ------------------ Desafio extra modulo 8.1 -------------------------------------------------

    public TarefaDTO atualizarTarefa(Long id, TarefaDTO tarefaDTO) {
        Tarefa encontrada = tarefaRepository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));

        encontrada.setNome(tarefaDTO.getNome());
        encontrada.setPrioridade(tarefaDTO.getPrioridade());
        encontrada.setConcluida(tarefaDTO.isConcluida());

        return toDto(tarefaRepository.save(encontrada));

    }

    // NOVO · DELETE /tarefas/{id}
    // Devolve se conseguiu. Quem traduz pra HTTP e a controller.
    // ------------------ Desafio extra modulo 8.1 -------------------------------------------------

    public void deletarTarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new TarefaNaoEncontradaException(id);
        }
        tarefaRepository.deleteById(id);
    }

    private TarefaDTO toDto(Tarefa tarefa) {
        return new TarefaDTO(tarefa.getId(), tarefa.getNome(),
                tarefa.getPrioridade(), tarefa.getConcluida());
    }

    private Tarefa toEntity(TarefaDTO tarefaDTO) {
        return new Tarefa(tarefaDTO.getNome(), tarefaDTO.getPrioridade(),
                tarefaDTO.isConcluida());
    }
}