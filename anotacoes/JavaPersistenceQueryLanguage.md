---

## 🗂️ Estrutura Básica

| Elemento | Descrição | Exemplo |
|-----------|------------|---------|
| **SELECT** | Seleciona entidades ou atributos | `SELECT e FROM Empregado e` |
| **WHERE** | Filtra resultados | `SELECT e FROM Empregado e WHERE e.salario > 3000` |
| **ORDER BY** | Ordena os resultados | `SELECT e FROM Empregado e ORDER BY e.nome ASC` |
| **GROUP BY** | Agrupa resultados | `SELECT d.nome, COUNT(e) FROM Empregado e JOIN e.departamento d GROUP BY d.nome` |
| **HAVING** | Filtra grupos agregados | `SELECT d.nome, COUNT(e) FROM Empregado e JOIN e.departamento d GROUP BY d.nome HAVING COUNT(e) > 5` |

---

## 🔄 Cláusulas de Junção (JOINs)

| Tipo | Descrição | Exemplo |
|------|------------|---------|
| **INNER JOIN** | Retorna apenas registros com correspondência | `SELECT e FROM Empregado e JOIN e.departamento d` |
| **LEFT JOIN** | Retorna todos os registros da esquerda (entidade principal) mesmo sem correspondência | `SELECT e FROM Empregado e LEFT JOIN e.projetos p` |
| **FETCH JOIN** | Carrega relacionamentos de forma imediata (Eager Fetch) | `SELECT e FROM Empregado e JOIN FETCH e.departamento` |

---

## 🎯 Operadores Comuns

| Operador | Descrição | Exemplo |
|-----------|------------|---------|
| `=` | Igualdade | `WHERE e.nome = 'João'` |
| `<>` ou `!=` | Diferente | `WHERE e.departamento <> 'RH'` |
| `>` / `<` / `>=` / `<=` | Comparação numérica | `WHERE e.salario >= 5000` |
| `BETWEEN` | Faixa de valores | `WHERE e.idade BETWEEN 25 AND 40` |
| `LIKE` | Busca textual com padrões | `WHERE e.nome LIKE 'J%'` |
| `IN` | Conjunto de valores | `WHERE e.cargo IN ('DEV', 'QA')` |
| `IS NULL` / `IS NOT NULL` | Verifica valores nulos | `WHERE e.departamento IS NOT NULL` |

---

## 🔢 Funções de Agregação

| Função | Descrição | Exemplo |
|---------|------------|---------|
| `COUNT()` | Conta registros | `SELECT COUNT(e) FROM Empregado e` |
| `AVG()` | Média | `SELECT AVG(e.salario) FROM Empregado e` |
| `SUM()` | Soma | `SELECT SUM(e.salario) FROM Empregado e` |
| `MAX()` | Maior valor | `SELECT MAX(e.salario) FROM Empregado e` |
| `MIN()` | Menor valor | `SELECT MIN(e.salario) FROM Empregado e` |

---

## 🧩 Subconsultas (Subqueries)

| Tipo | Exemplo | Descrição |
|------|----------|-----------|
| **Na cláusula WHERE** | `SELECT e FROM Empregado e WHERE e.salario > (SELECT AVG(e2.salario) FROM Empregado e2)` | Retorna empregados com salário acima da média |
| **Com IN** | `SELECT e FROM Empregado e WHERE e.departamento.id IN (SELECT d.id FROM Departamento d WHERE d.nome LIKE 'Eng%')` | Retorna empregados de departamentos específicos |

---

## 🧠 Expressões e Funções Úteis

| Função | Descrição | Exemplo |
|---------|------------|---------|
| `CONCAT()` | Concatena strings | `SELECT CONCAT(e.nome, ' ', e.sobrenome) FROM Empregado e` |
| `LOWER()` / `UPPER()` | Manipula caixa de texto | `WHERE UPPER(e.nome) = 'JOÃO'` |
| `LENGTH()` | Retorna tamanho da string | `WHERE LENGTH(e.nome) > 5` |
| `CURRENT_DATE` / `CURRENT_TIME` / `CURRENT_TIMESTAMP` | Data e hora atuais | `WHERE e.dataAdmissao < CURRENT_DATE` |

---

## 🧮 JPQL com Spring Data JPA

| Tipo | Exemplo | Descrição |
|------|----------|-----------|
| **Query baseada em método** | `List<Empregado> findBySalarioGreaterThan(Double salario);` | Criação automática da consulta |
| **@Query (JPQL)** | `@Query("SELECT e FROM Empregado e WHERE e.nome LIKE %:nome%")` | Consulta personalizada |
| **Parâmetros nomeados** | `@Query("SELECT e FROM Empregado e WHERE e.departamento.id = :id")` | Usa `:id` como parâmetro |
| **Parâmetros posicionais** | `@Query("SELECT e FROM Empregado e WHERE e.salario > ?1")` | Usa posição (`?1`, `?2`, etc.) |

---

## 🧩 Dicas Avançadas

| Dica | Exemplo |
|------|----------|
| Evite `SELECT *` → use aliases | `SELECT e FROM Empregado e` |
| Prefira `JOIN FETCH` para evitar `LazyInitializationException` | `SELECT e FROM Empregado e JOIN FETCH e.projetos` |
| Use DTOs para projeções parciais | `SELECT new com.exemplo.EmpregadoDTO(e.nome, e.salario) FROM Empregado e` |
| Combine JPQL com **Specification API** para consultas dinâmicas | `JpaSpecificationExecutor` |

---

## 🧾 Recursos Recomendados

- [Documentação oficial do JPA](https://jakarta.ee/specifications/persistence/)
- [Spring Data JPA Reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)
- [Baeldung – JPQL Tutorial](https://www.baeldung.com/jpa-queries)

---

📚 **Autor:** RafaelGx — Guia de apoio para estudo e prática de JPQL com Spring Data JPA.  
🗓️ **Última atualização:** Novembro/2025
