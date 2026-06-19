# 📖 API Gerenciamento de Biblioteca

API REST desenvolvida com **Spring Boot 4** e **Java 21** para gerenciamento de uma biblioteca, permitindo o cadastro e controle de **Autores** e **Livros** com relacionamento entre as entidades, persistidos em banco de dados **PostgreSQL** via **Spring Data JPA**.

> Projeto de estudo com foco em arquitetura REST em camadas (Controller → Service → Repository), relacionamento entre entidades JPA e boas práticas com Lombok.

---

## 🚀 Tecnologias utilizadas

| Tecnologia | Versão |
|---|---|
| Java | 21 |
| Spring Boot | 4.0.6 |
| Spring Web (MVC) | — |
| Spring Data JPA | — |
| PostgreSQL | — |
| Lombok | — |
| Spring DevTools | — |
| Maven | — |

---

## 🗂️ Estrutura do projeto

```
src/main/java/com/lucasvargas/dev/api_gerenciamento_biblioteca/
├── ApiGerenciamentoBibliotecaApplication.java   # Entry point
├── controller/
│   ├── AutorController.java                     # Endpoints REST de Autor
│   └── LivroController.java                     # Endpoints REST de Livro
├── service/
│   ├── AutorService.java                        # Regras de negócio de Autor
│   └── LivroService.java                        # Regras de negócio de Livro
├── repository/
│   ├── AutorRepository.java                     # Acesso a dados de Autor
│   └── LivroRepository.java                     # Acesso a dados de Livro
└── model/
    ├── AutorModel.java                          # Entidade tb_autor
    └── LivroModel.java                          # Entidade tb_livro (ManyToOne → Autor)
```

---

## 🧩 Modelo de dados

### `AutorModel` → tabela `tb_autor`

| Campo | Tipo | Descrição |
|---|---|---|
| `id` | Long | Identificador único (auto-gerado) |
| `nome` | String | Nome do autor |
| `sobre` | String | Biografia / descrição |
| `dataDeNascimento` | LocalDate | Data de nascimento |
| `nacionalidade` | String | Nacionalidade do autor |

### `LivroModel` → tabela `tb_livro`

| Campo | Tipo | Descrição |
|---|---|---|
| `id` | Long | Identificador único (auto-gerado) |
| `titulo` | String | Título do livro |
| `anoPublicacao` | Integer | Ano de publicação |
| `sobre` | String | Sinopse / descrição |
| `linguaOriginal` | String | Língua original da obra |
| `quantidadePaginas` | Integer | Número de páginas |
| `autorDoLivro` | AutorModel | Referência ao autor (`@ManyToOne`) |

> O relacionamento é **muitos livros para um autor** — um autor pode ter vários livros cadastrados.

---

## 📡 Endpoints da API

### 📌 Autor — `/v1/autor`

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/v1/autor` | Cadastra um novo autor |
| `GET` | `/v1/autor` | Lista todos os autores |
| `GET` | `/v1/autor/{id}` | Busca um autor pelo ID |
| `PUT` | `/v1/autor/{id}` | Atualiza os dados de um autor |
| `DELETE` | `/v1/autor/{id}` | Remove um autor pelo ID |

#### Exemplo de corpo (POST/PUT)
```json
{
  "nome": "Clarice Lispector",
  "sobre": "Clarice Lispector, nascida Chaya Pinkhasivna Lispector, foi uma escritora e jornalista de origem ucraniana-judaica.",
  "dataDeNascimento": "1920-10-12",
  "nacionalidade": "brasileira"
}
```

---

### 📌 Livro — `/v1/livro`

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/v1/livro` | Cadastra um novo livro |
| `GET` | `/v1/livro` | Lista todos os livros |
| `GET` | `/v1/livro/{id}` | Busca um livro pelo ID |
| `PUT` | `/v1/livro/{id}` | Atualiza os dados de um livro |
| `DELETE` | `/v1/livro/{id}` | Remove um livro pelo ID |

#### Exemplo de corpo (POST/PUT)
```json
{
  "titulo": "A Hora da Estrela",
  "anoPublicacao": 1977,
  "sobre": "A Hora da Estrela é um romance literário da escritora brasileira Clarice Lispector.",
  "linguaOriginal": "Brasileira",
  "quantidadePaginas": 87,
  "autorDoLivro": {
    "id": 1
  }
}
```

---

## 🖥️ Screenshots

### Banco de dados — DBeaver (PostgreSQL)

Dados das tabelas `tb_autor` e `tb_livro` visualizados no DBeaver, conectado ao banco `bdbiblioteca` na porta `5432`:

<img width="1365" height="728" alt="image" src="https://github.com/user-attachments/assets/ec0f9409-41da-4e29-8871-12a9f2fb54c2" />


---

### Testes da API — Insomnia

Resposta do endpoint `GET /v1/livro` retornando a lista de livros com o objeto `autorDoLivro` aninhado, testado no Insomnia (`200 OK`):

<img width="1365" height="728" alt="image" src="https://github.com/user-attachments/assets/51dde0da-6e25-4097-88d0-e2b51a896687" />


---

## ⚙️ Configuração

Ajuste o arquivo `src/main/resources/application.properties` com suas credenciais do PostgreSQL:

```properties
spring.application.name=api-gerenciamento-biblioteca

server.port:8080

spring.datasource.url:jdbc:postgresql://localhost:5432/bdbiblioteca
spring.datasource.username:seu_usuario
spring.datasource.password:sua_senha

spring.jpa.hibernate.ddl-auto:update

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> ⚠️ Crie o banco de dados `bdbiblioteca` no PostgreSQL antes de iniciar a aplicação. O JPA criará as tabelas automaticamente via `ddl-auto=update`.

---

## ▶️ Como executar

### Pré-requisitos
- Java 21
- PostgreSQL em execução
- Maven ou Maven Wrapper (incluído no projeto)

### Passos

```bash
# 1. Clone o repositório
git clone https://github.com/lucasvargass/api-gerenciamento-biblioteca.git
cd api-gerenciamento-biblioteca

# 2. Configure o application.properties com suas credenciais do PostgreSQL

# 3. Execute a aplicação
./mvnw spring-boot:run
```

No Windows:
```bash
mvnw.cmd spring-boot:run
```

A API estará disponível em:
```
http://localhost:8080
```

---

## 🧪 Testes

O projeto possui estrutura de testes com **JUnit** e **Spring Boot Test**:

```bash
./mvnw test
```

---

## 🗺️ Roadmap / Próximos passos

- [ ] Implementar DTOs para desacoplar a camada de API das entidades JPA
- [ ] Adicionar validações com Bean Validation (`@NotBlank`, `@NotNull`, etc.)
- [ ] Criar tratamento global de exceções com `@ControllerAdvice`
- [ ] Documentar a API com **Swagger / OpenAPI**
- [ ] Escrever testes unitários para `service` e `controller`
- [ ] Adicionar paginação nos endpoints de listagem
- [ ] Containerizar com **Docker** e **Docker Compose**

---

## 👨‍💻 Autor

Desenvolvido por **Lucas Vargas** como projeto de estudo em desenvolvimento backend com Java e Spring Boot.

- GitHub: [@lucasvargass](https://github.com/lucasvargass)
