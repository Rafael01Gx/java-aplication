# 📘 Anotações do Hibernate (JPA)

O **Hibernate** é uma das implementações mais populares da **JPA (Java Persistence API)**.  
Ele fornece um conjunto de **anotações** que facilitam o **mapeamento objeto-relacional (ORM)** — ou seja, o processo de mapear classes Java para tabelas de banco de dados.

---

## 🧩 1. @Entity
Marca uma classe como uma **entidade persistente**, ou seja, ela será mapeada para uma tabela no banco de dados.

```java
@Entity
public class Produto { ... }
```

Cada entidade representa uma tabela, e cada instância da classe representa uma linha nessa tabela.

---

## 🗂️ 2. @Table
Por padrão, o Hibernate utiliza o **nome da classe** como nome da tabela (convertendo de `PascalCase` para `snake_case`).  
Para personalizar, utilize a anotação `@Table`.

```java
@Entity
@Table(name = "minha_tabela")
public class MinhaEntidade { ... }
```

**Parâmetros comuns:**
- `name`: Nome da tabela no banco de dados.
- `schema`: Esquema do banco onde a tabela se encontra.
- `uniqueConstraints`: Define restrições de unicidade.

---

## 🔑 3. @Id
Define o **identificador único** da entidade (chave primária).

```java
@Id
private Long id;
```

---

## ⚙️ 4. @GeneratedValue
Usada junto com `@Id`, define a **estratégia de geração automática da chave primária**.

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

**Estratégias possíveis:**
- `AUTO` → O provedor escolhe automaticamente.
- `IDENTITY` → Usa auto-incremento (MySQL, PostgreSQL).
- `SEQUENCE` → Usa sequência (Oracle).
- `TABLE` → Usa uma tabela auxiliar para gerar IDs.

---

## 📋 5. @Column
Permite personalizar o mapeamento de um campo para uma coluna específica.

```java
@Column(name = "nome_completo", nullable = false)
private String nome;
```

**Parâmetros comuns:**
- `name`: Nome da coluna.
- `nullable`: Define se o campo pode ser `NULL`.
- `length`: Tamanho máximo (para `String`).
- `unique`: Define se o valor deve ser único.

---

## 🔁 6. Relacionamentos Entre Entidades

### ➕ @OneToMany e @ManyToOne
Usadas para mapear relacionamentos **um-para-muitos** e **muitos-para-um**.

```java
@Entity
public class Autor {
    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;
}

@Entity
public class Livro {
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
}
```

---

### 🔗 @ManyToMany
Mapeia relacionamentos **muitos-para-muitos**.

```java
@Entity
public class Estudante {
    @ManyToMany
    @JoinTable(
        name = "inscricao",
        joinColumns = @JoinColumn(name = "estudante_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;
}
```

---

### ⚖️ @OneToOne
Usada para relacionamentos **um-para-um**.

```java
@OneToOne
@JoinColumn(name = "perfil_id")
private Perfil perfil;
```

---

### 🧩 @JoinColumn
Define a **coluna de junção** usada em relacionamentos.

```java
@ManyToOne
@JoinColumn(name = "autor_id")
private Autor autor;
```

---

### 🧷 @JoinTable
Define uma **tabela intermediária** usada em relacionamentos `@ManyToMany`.

```java
@ManyToMany
@JoinTable(
    name = "inscricao",
    joinColumns = @JoinColumn(name = "estudante_id"),
    inverseJoinColumns = @JoinColumn(name = "curso_id")
)
private List<Curso> cursos;
```

---

## 🧭 7. @Transient
Indica que um campo **não deve ser persistido** no banco de dados.

```java
@Transient
private String valorTemporario;
```

---

## 🎯 8. @Enumerated
Mapeia **enums Java** para colunas do banco.

```java
@Enumerated(EnumType.STRING)
private Status status;
```

**Opções:**
- `EnumType.ORDINAL` → Armazena o índice numérico.
- `EnumType.STRING` → Armazena o nome literal (recomendado).

---

## 📑 9. @NamedQuery
Define **consultas nomeadas (JPQL)** reutilizáveis.

```java
@Entity
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente { ... }
```

---

## 🔄 10. @Cascade
Configura o **comportamento em cascata** entre entidades relacionadas.

```java
@OneToMany(mappedBy = "departamento")
@Cascade(CascadeType.SAVE_UPDATE)
private List<Funcionario> funcionarios;
```

---

## 🧱 11. @Embeddable e @Embedded
Permitem **incorporar tipos complexos** dentro de entidades.

```java
@Embeddable
public class Endereco {
    private String rua;
    private String cidade;
}

@Entity
public class Cliente {
    @Embedded
    private Endereco endereco;
}
```

---

## 📚 Conclusão

O uso correto das anotações do **Hibernate/JPA** é essencial para:
- Garantir **coerência entre classes e tabelas**;
- Melhorar o **desempenho e a legibilidade** do código;
- Reduzir **boilerplate** e configurações manuais.

🔍 Consulte sempre a [documentação oficial do Hibernate](https://hibernate.org/orm/documentation/) para aprofundar seu conhecimento.

---

📖 **Autor:** Rafael Junio  
💻 **Tecnologias:** Java, Hibernate, JPA, ORM  
🕓 **Última atualização:** Novembro de 2025
