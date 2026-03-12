# 🛒 Supermercado Java — API REST

[![Status](https://img.shields.io/badge/Status-Backend_em_Produção-blue?style=for-the-badge)](https://github.com/WendeNJ/Supermercado-java)
[![Java](https://img.shields.io/badge/Java-11+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![JPA](https://img.shields.io/badge/JPA%2FHibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)](https://hibernate.org)

API REST completa para gerenciamento de supermercado — produtos, estoque, fornecedores e vendas.  
Arquitetura limpa em camadas com Spring Boot e JPA/Hibernate.

---

## 📌 Sobre o Projeto

Sistema back-end desenvolvido para gerenciar as operações de um supermercado, expondo uma API REST robusta e bem organizada. O projeto demonstra domínio de **arquitetura em camadas**, **modelagem de domínio** e **boas práticas com Spring Boot**.

---

## ✨ Funcionalidades

| Funcionalidade | Descrição |
|---|---|
| 📦 Cadastro de Produtos | Nome, preço, categoria e estoque |
| 🏷️ Gestão de Categorias | Organização e filtragem de produtos |
| 🚚 Cadastro de Fornecedores | Controle de parceiros e abastecimento |
| 🛍️ Registro de Vendas | Criação de vendas com múltiplos itens |
| 📊 Controle de Estoque | Atualização automática após vendas |

---

## 🛠️ Tecnologias

| Tecnologia | Uso |
|---|---|
| Java 11+ | Linguagem principal |
| Spring Boot | Framework da aplicação |
| Spring Data JPA | Repositórios e queries |
| Hibernate | Mapeamento objeto-relacional |
| H2 Database | Banco em memória para desenvolvimento |
| Maven | Gerenciamento de dependências |
| DTO Pattern | Comunicação entre camadas |

---

## 🏗️ Arquitetura

```
src/
├── controller/     # Endpoints REST (rotas da API)
├── service/        # Regras de negócio
├── repository/     # Acesso ao banco de dados (Spring Data JPA)
├── model/          # Entidades JPA (tabelas do banco)
└── dto/            # Objetos de transferência de dados
```

### Modelo de Domínio

```
Produto ────── Categoria
   │
   └──── ItemVenda ────── Venda
   │
Fornecedor
```

---

## 📡 Endpoints da API

### Produtos

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/produtos` | Lista todos os produtos |
| `GET` | `/produtos/{id}` | Busca produto por ID |
| `POST` | `/produtos` | Cria novo produto |
| `PUT` | `/produtos/{id}` | Atualiza produto |
| `DELETE` | `/produtos/{id}` | Remove produto |

### Vendas

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/vendas` | Registra nova venda |
| `GET` | `/vendas/{id}` | Busca venda por ID |

### Fornecedores

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/fornecedores` | Lista fornecedores |
| `POST` | `/fornecedores` | Cadastra fornecedor |

---

## ▶️ Como Rodar

### Pré-requisitos

- Java 11+
- Maven 3.6+

```bash
# 1. Clone o repositório
git clone https://github.com/WendeNJ/Supermercado-java.git
cd Supermercado-java

# 2. Execute com Maven
./mvnw spring-boot:run

# 3. Acesse a API
# http://localhost:8080

# 4. (Opcional) Console H2
# http://localhost:8080/h2-console
```

> 💡 O banco H2 já vem configurado. Nenhuma instalação de banco de dados é necessária para rodar localmente.

### Testando com Postman

Importe a collection ou faça requisições diretamente:

```bash
# Listar produtos
curl http://localhost:8080/produtos

# Criar produto
curl -X POST http://localhost:8080/produtos \
  -H "Content-Type: application/json" \
  -d '{"nome": "Arroz 5kg", "preco": 25.90, "estoque": 100}'
```

---

## 🗺️ Roadmap

- [x] CRUD de Produtos
- [x] Gestão de Categorias
- [x] Cadastro de Fornecedores
- [x] Registro de Vendas
- [x] Controle de Estoque automático
- [ ] Front-end em React *(em desenvolvimento)*
- [ ] Autenticação JWT
- [ ] Relatórios de vendas

---

## 👨‍💻 Autor

**Wenderson Carvalho de Araújo Mota**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/wendersonmota/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white)](https://github.com/WendeNJ)
