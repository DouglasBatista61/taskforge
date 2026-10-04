package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// A controller so traduz HTTP <-> Java. Os "if" daqui escolhem o codigo HTTP, nao regra.
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    // GET /tarefas            -> todas
    // GET /tarefas?concluida=true  -> so as concluidas
    // required = false: sem o parametro, concluida chega null
    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listar(
            @RequestParam(required = false) Boolean concluida) {
        return ResponseEntity.ok(tarefaService.buscarTodos(concluida));
    }
    // --------------- Exercicio 5 modulo 5.2 --------------------------------------


    @GetMapping("/pendentes")
    public ResponseEntity<List<TarefaDTO>> buscarPendentes(
            @RequestParam(required = false) Boolean concluida) {
        return ResponseEntity.ok(tarefaService.buscarPendentes(concluida));
    }

    //-------------------------------------------------------------------------------

    // ------------------Exercicio 6 modulo 5.2 -------------------------------------

    @GetMapping("/urgentes")
    public ResponseEntity<List<TarefaDTO>> buscarUrgentes(
            @RequestParam(required = false) Boolean concluida, Integer prioridade) {
        return ResponseEntity.ok(tarefaService.buscarUrgentes(prioridade, concluida));
    }

    //----------------- Questionario 6B modulo 5.2 ----------------------------------
    // 1 - O que é diferente entre os dois metodos novos da controller, alem do nome da url?
    //  Visualmente são praticamente identicos, o corpo usado no metodo é o mesmo, o que muda é nome do metodo,
    //  e o que ele busca, um busca 1 parametro e outro 2 parametros.

    // 2 - Amanhã o cliente decide: "Urgente agora é uma prioridade 1 ou 2". Quantos arquivos você abre pra mudar? quais?
    // Abro o arquivo TarefaService, pq ele faz a regra, ele que monta o "hamburguer", e tambem o Repository porque caso a
    // priordade aggora tenha dois valores int 1,2 por exemplo, precisaria cria um novo metodo para receber as duas.
    // Agora se continuar somente um valor de prioridade so muda a service mesmo. A controller não muda nada ela só é o "Garçom".


    // ------------------------------------------------------------------------------

    // GET /tarefas/2 -> 200 | 404
    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> buscarPorId(@PathVariable Long id) {
        Optional<TarefaDTO> tarefa = tarefaService.buscarPorId(id);
        if (tarefa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefa.get());
    }

    // POST /tarefas -> 201
    @PostMapping
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO tarefaCriada = tarefaService.criarTarefa(tarefaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
    }

    // PUT /tarefas/2 -> 200 | 404
    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
        Optional<TarefaDTO> atualizada = tarefaService.atualizarTarefa(id, tarefaDTO);
        if (atualizada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizada.get());
    }

    // DELETE /tarefas/2 -> 204 | 404
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        if (!tarefaService.deletarTarefa(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

// ------------------- Exercicio 7 modulo 5.2 -------------------------------------------------------

// Pra cada situação, escreva a camada: CONTROLLER SERVICE ou REPOSITORY .
//A SITUAÇÃO A CAMADA
//1 "só mostrar as categorias que estão ativas": ---- Service ----
//2 "o endereço vai ser /categorias/ativas": ---- Controller -----
//3 extends JpaRepository<Categoria, Long>: ---- Repository -----
//4 "tarefa atrasada é a que passou do prazo e não está concluída" ---- Service ----
//5 o @GetMapping: ---- Controller ----
//6 "buscar e guardar no banco": ---- Repository -----
//7 "uma categoria desativada não aparece pra ninguém": ---- Service ----
//8 "devolver a lista em JSON pro navegador" ---- Controller -----

// Um colega mandou esta controller. Ela compila, roda e devolve o JSON certo. E está errada em dois pontos.
//Quais? E como fica o conserto?

    //CATEGORIACONTROLLER.JAVA — DO COLEGA
        //@RestController
        //public class CategoriaController {

            //private final CategoriaRepository repository;                  <-- private final CategoriaService categoriaService;

            //public CategoriaController(CategoriaRepository repository) {   <-- (CategoriaService categoriaService)
                //this.repository = repository;                              <-- this.categoriaservice = categoriaService
                //}

            //@GetMapping("/categorias/ativas")
            //public List<Categoria> listarAtivas() {
            //return repository.findAll().stream()                            <-- return ResponseEntity.ok(categoriaService.listarAtivas());
                 //.filter(c -> c.isAtiva())                                  <-- esses filtros não existem ai.
                 //.toList();
        //}
    //}
// ---- CORRIGIDO ---

    //@RestController
    //public class CategoriaController {

        //private final CategoriaService categoriaService;

         //public CategoriaController(CategoriaService categoriaService) {
            //this.categoriaService = categoriaService;
        // }

            //@GetMapping("/categorias/ativas")
            //public ResponseEntity<List<CategoriaDTO>> listarAtivas() {
                //return ResponseEntity.ok(categoriaService.listarAtivas());
        //  }
    // }

 // ---------------------------------------------------------------------------------------------

// -------------------------- Exercicio 8 modulo 5.2 --------------------------------------------

//  A. Pra cada uma escreva a causa e o conserto. Uma linha cada

//<dependency>
    //<groupId>org.projectlombok</groupId>
    //<artifactId>lombok</artifactId>
    //<version>0.9.2</version>               --> Não é necessario a versão, ja vem por padrão a versão certa.
    //<scope>compile</scope>                 --> Não é necessario o scope.
//</dependency>

//  B · LOGO DEPOIS DE COLAR O LOMBOK, A TAREFA ACENDE 8 ERROS
//Tarefa.java
//java: package jakarta.persistence does not exist
//java: package jakarta.persistence does not exist
//java: package jakarta.persistence does not exist
//java: package jakarta.persistence does not exist
//java: cannot find symbol   symbol: class Entity
//java: cannot find symbol   symbol: class Id
//java: cannot find symbol   symbol: class GeneratedValue
//java: cannot find symbol   symbol: variable GenerationType

// É um erro na biblioteca JPA que ocorre por falta da dependencia no arquivo pom.xml.
// Como eu não lembrava a dependencia fui pesquisar, é a dependencia do Spring boot, que ja traz a
// Jpa e o hibernate.
//        <dependency>
//            <groupId>org.springframework.boot</groupId>
//            <artifactId>spring-boot-starter-data-jpa</artifactId>
//        </dependency>


// C · A LINHA EM CIMA DA CLASSE FICA VERMELHA
//@getter
//public class Tarefa {
//java: cannot find symbol
//symbol: class getter

// Esse erro pode ser tanto por conta do @getter estar com o g minusculo, seria assim @Getter ou
// algum erro na biblioteca lombok por conta da dependencia.

//  D · NO H2-CONSOLE, AO CLICAR EM CONNECT
//JDBC URL:  jdbc:h2:mem:testdb
//Database "mem:testdb" not found, either pre-create it or allow
//remote database creation (not recommended in secure environments)

//Eu começaria trantando esse erro vericando se as informações do application properties batem com
// a do console, URL, server-port. Pode haver algum dado errado que esteja indicando um banco inexistente.


//  E · "ZEROU TUDO" — SEM ERRO NENHUM NO LOG
//INSERT INTO TAREFA ...   (3 linhas, tudo certo)
//SELECT * FROM TAREFA;    -> 3 linhas
//(parar o servidor, rodar de novo)
//SELECT * FROM TAREFA;    -> vazio

// Ocorre pq o banco está salvo na mem, para que os dados persistam precisa estar salvo em file.


//  F · O TOPO DA CONTROLLER DE UM COLEGA
//@Service                             <-- Esse @Service não deveria existir ai.
//@RestController
//public class TarefaController {



//  G · CÓDIGO NOVO NA TELA, COMPORTAMENTO VELHO RODANDO
// - trocou o nome do méodo na controller,
// - salvou, rodou de novo
// - o navegador continua mostrando o resultado de antes
// - pôs um breakpoint dentro do listar() e ele NÃO PARA
// - o H2 está certo, a requisição chega (conferido no DevTools)
// - já clicou em "Clean" na IDE.




