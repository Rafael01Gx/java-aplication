| Tipo                           | Keyword                         | Descrição                              | Exemplo                                                        |
| ------------------------------ | ------------------------------- | -------------------------------------- | -------------------------------------------------------------- |
| **Comparação**                 | `Is`, `Equals`                  | Igualdade (`=`)                        | `findByName(String name)` ou `findByNameIs(String name)`       |
|                                | `IsNot`, `Not`                  | Diferente (`<>`)                       | `findByNameNot(String name)`                                   |
|                                | `LessThan`                      | Menor que (`<`)                        | `findByAgeLessThan(int age)`                                   |
|                                | `LessThanEqual`                 | Menor ou igual (`<=`)                  | `findByAgeLessThanEqual(int age)`                              |
|                                | `GreaterThan`                   | Maior que (`>`)                        | `findByAgeGreaterThan(int age)`                                |
|                                | `GreaterThanEqual`              | Maior ou igual (`>=`)                  | `findByAgeGreaterThanEqual(int age)`                           |
|                                | `Between`                       | Entre dois valores (`BETWEEN`)         | `findByAgeBetween(int start, int end)`                         |
|                                | `Before`                        | Antes (datas)                          | `findByCreatedDateBefore(LocalDate date)`                      |
|                                | `After`                         | Depois (datas)                         | `findByCreatedDateAfter(LocalDate date)`                       |
| **Nulos e Booleanos**          | `IsNull`                        | Campo nulo                             | `findByEmailIsNull()`                                          |
|                                | `IsNotNull`                     | Campo não nulo                         | `findByEmailIsNotNull()`                                       |
|                                | `True`                          | Valor booleano `true`                  | `findByActiveTrue()`                                           |
|                                | `False`                         | Valor booleano `false`                 | `findByActiveFalse()`                                          |
| **Texto e Padrões**            | `Like`                          | Correspondência parcial (`LIKE`)       | `findByNameLike(String pattern)`                               |
|                                | `NotLike`                       | Não corresponde ao padrão              | `findByNameNotLike(String pattern)`                            |
|                                | `StartingWith` / `StartsWith`   | Começa com (`LIKE 'abc%'`)             | `findByNameStartingWith(String prefix)`                        |
|                                | `EndingWith` / `EndsWith`       | Termina com (`LIKE '%xyz'`)            | `findByNameEndingWith(String suffix)`                          |
|                                | `Containing` / `Contains`       | Contém (`LIKE '%abc%'`)                | `findByNameContaining(String infix)`                           |
|                                | `NotContaining` / `NotContains` | Não contém                             | `findByNameNotContaining(String infix)`                        |
|                                | `IgnoreCase`                    | Ignora maiúsc./minúsc.                 | `findByNameIgnoreCase(String name)`                            |
| **Coleções**                   | `In`                            | Dentro de uma lista (`IN (...)`)       | `findByIdIn(List<Long> ids)`                                   |
|                                | `NotIn`                         | Fora de uma lista                      | `findByIdNotIn(List<Long> ids)`                                |
|                                | `Empty`                         | Lista vazia                            | `findByTagsEmpty()`                                            |
|                                | `IsNotEmpty`                    | Lista não vazia                        | `findByTagsIsNotEmpty()`                                       |
| **Lógicas**                    | `And`                           | E lógico (`AND`)                       | `findByNameAndAge(String name, int age)`                       |
|                                | `Or`                            | Ou lógico (`OR`)                       | `findByNameOrEmail(String name, String email)`                 |
| **Ordenação e Limite**         | `OrderBy`                       | Ordena resultado                       | `findByAgeGreaterThanOrderByNameAsc(int age)`                  |
|                                | `Asc`                           | Ascendente                             | `findByOrderByNameAsc()`                                       |
|                                | `Desc`                          | Descendente                            | `findByOrderByNameDesc()`                                      |
| **Existência**                 | `Exists`                        | Verifica existência                    | `existsByEmail(String email)`                                  |
| **Negação**                    | `Not`                           | Nega condição                          | `findByNameNot(String name)`                                   |
| **Data e Tempo**               | `Before`                        | Data anterior                          | `findByDateBefore(LocalDate d)`                                |
|                                | `After`                         | Data posterior                         | `findByDateAfter(LocalDate d)`                                 |
| **Enumerações e Objetos**      | `Is`                            | Igualdade em enums/objetos             | `findByStatusIs(Status.ACTIVE)`                                |
|                                | `Not`                           | Diferente                              | `findByStatusNot(Status.INACTIVE)`                             |
| **Limite de Resultados**       | `Top`, `First`                  | Limita número de registros             | `findTop3ByOrderByAgeDesc()` ou `findFirstByName(String name)` |
| **Distinção**                  | `Distinct`                      | Elimina duplicatas (`SELECT DISTINCT`) | `findDistinctByName(String name)`                              |
| **Negação Avançada**           | `IsNot`                         | Negação de igualdade                   | `findByNameIsNot(String name)`                                 |
| **Aninhamento (Propriedades)** | `Property_NestedProperty`       | Navega por relacionamentos             | `findByAddress_City(String city)`                              |
| **Combinação com Paginação**   | (usando `Pageable`)             | Retorna página de resultados           | `findByStatus(Status s, Pageable pageable)`                    |



// Exemplo
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private double preco;

    private boolean emEstoque;

    // Getters e Setters
    // ...
}

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    /**
     * Exemplo de Derived Query complexa:
     * - Encontra Produtos
     * - Onde o nome contenha o termo (Containing)
     * - Ignorando a caixa (IgnoreCase)
     * - E o produto esteja em estoque (And EmEstoqueTrue)
     * - Ordenado pelo Preço em ordem Decrescente (OrderBy PrecoDesc)
     */
    List<Produto> findByNomeContainingIgnoreCaseAndEmEstoqueTrueOrderByPrecoDesc(String termoBusca);

    // --- Outros Exemplos Rápidos ---

    /**
     * Exemplo de Between:
     * Encontra produtos com preço entre os valores min e max.
     */
    List<Produto> findByPrecoBetween(double precoMin, double precoMax);

    /**
     * Exemplo de Top e LessThanEqual:
     * Encontra o produto mais barato (Top 1) com preço <= precoMax.
     */
    Produto findTop1ByPrecoLessThanEqualOrderByPrecoAsc(double precoMax);
}