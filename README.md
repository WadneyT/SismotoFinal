# Sismoto

Sistema web desenvolvido em Java Web utilizando JSP, Servlet e PostgreSQL.

---

## Tecnologias Utilizadas

- Java 7/8
- JSP
- Servlet
- PostgreSQL
- GlassFish Server 4.1
- NetBeans
- JDBC

---

## Estrutura do Projeto

```text
Controller   -> Servlets/controllers do sistema
Model        -> Classes modelo
Negocio      -> Regras de negócio
Persistencia -> Comunicação com banco de dados
util         -> Conexão e utilidades
web          -> Arquivos JSP
```

---

## Funcionalidades

- Cadastro de Clientes
- Cadastro de Produtos
- Cadastro de Pedidos
- Listagem de registros
- Alteração de registros
- Exclusão de registros

---

## Banco de Dados

Banco utilizado: PostgreSQL.

Necessário configurar os dados de conexão na classe:

```text
util/Conexao.java
```

Exemplo de configuração:

```java
String url = "jdbc:postgresql://localhost:5432/sismoto";
String usuario = "XPTO";
String senha = "AWSD";
```

---

## Biblioteca PostgreSQL

O projeto utiliza o driver JDBC:

```text
postgresql-42.2.29.jre7.jar
```

A biblioteca já está presente na pasta `lib`.

---

## Como Executar

1. Abrir o projeto no NetBeans
2. Configurar o GlassFish Server 4.1
3. Criar o banco de dados PostgreSQL
4. Configurar a conexão no arquivo `Conexao.java`
5. Executar o projeto

---

## URL Inicial

```text
http://localhost:8080/Sismoto
```

---

## Estrutura MVC Utilizada

O projeto segue o padrão MVC:

- Model → Classes de entidade
- View → Páginas JSP
- Controller → Servlets
- Negocio → Regras de negócio
- Persistencia → Operações no banco de dados

---

## Autor

Projeto acadêmico desenvolvido para a disciplina de Web 1.
