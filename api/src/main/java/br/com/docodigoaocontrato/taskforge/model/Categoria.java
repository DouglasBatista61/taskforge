package br.com.docodigoaocontrato.taskforge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Boolean ativa;
}


// Resposta da pergunta do exercicio 3 da 5.1

// Na primeira vez as informações sumiram pq o banco estava configurado pra rodar da memoria RAM ou seja na
// memoria temporaria, qaundo a aplicação para de rodar as informações são apagadas.
// Na segunda tentativa mudamos isso mudamos o diretorio de mem pra file,
// aonde agora essas informações irão persistir no banco de dados, na pasta data do projeto.


//Resposta do exercicio 8 da 5.1.

// A · A APLICAÇÃO NEM SOBE
//Caused by: org.hibernate.InstantiationException:
//No default constructor for entity 'Categoria'
//    - Falta de um construtor vazio na aplicação.

//B · A APLICAÇÃO NEM SOBE
//org.hibernate.AnnotationException:
//No identifier specified for entity: Categoria
//   - Falta a anotação @Id.

//C. NO H2-CONSOLE, AO CLICAR EM CONNECT
//Database "./data/taskforge" not found, either pre-create it
//or allow remote database creation
//    - O banco ainda não existe no console.

//D · A APLICAÇÃO SOBE, MAS A TABELA NÃO APARECE NO CONSOLE
//(nenhum erro no log — tudo verde)
//E · O NAVEGADOR NÃO ABRE O H2-CONSOLE
//    - Faltou o a anotação @Entity na aplicação.

//E · O NAVEGADOR NÃO ABRE O H2-CONSOLE
//Esta página não está funcionando / ERR_CONNECTION_REFUSED
//(e no log da aplicação: Tomcat started on port 54213)
//    - O server-port está diferente do declarado no application properties.

//F · OS DADOS SUMIRAM DEPOIS DE REINICIAR
//(nenhum erro — a tabela está lá, só vazia)
//    - As informações estão sendo armazenadas na memoria (mem).
//    mude para file, assim as informações irão persistir.