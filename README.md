<p align="center">
  <img src="https://img.shields.io/badge/Status-Backend_em_Produção-blue?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Java-11+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white"/>
  <img src="https://img.shields.io/badge/JPA%2FHibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white"/>
</p>

<h1 align="center">🛒 Supermercado Java</h1>

<p align="center">
  API REST completa para gerenciamento de supermercado — produtos, estoque, fornecedores e vendas.<br/>
  Arquitetura limpa em camadas com Spring Boot e JPA/Hibernate.
</p>

---

## 📌 Sobre o Projeto

Sistema back-end desenvolvido para gerenciar as operações de um supermercado, expondo uma API REST robusta e organizada. O projeto demonstra domínio de **arquitetura em camadas**, **modelagem de domínio** e **boas práticas com Spring Boot**.

---

## ✨ Funcionalidades

- 📦 **Cadastro de Produtos** — nome, preço, categoria e estoque
- 🏷️ **Gestão de Categorias** — organização e filtragem de produtos
- 🚚 **Cadastro de Fornecedores** — controle de parceiros e abastecimento
- 🛍️ **Registro de Vendas** — criação de vendas com múltiplos itens
- 📊 **Controle de Estoque** — atualização automática após vendas

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
Produto ──── Categoria
   │
   └──── ItemVenda ──── Venda
   │
Fornecedor
```

---

## 📡 Endpoints da API

### Produtos
| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/produtos` | Lista todos os produtos |
| GET | `/produtos/{id}` | Busca produto por ID |
| POST | `/produtos` | Cria novo produto |
| PUT | `/produtos/{id}` | Atualiza produto |
| DELETE | `/produtos/{id}` | Remove produto |

### Vendas
| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/vendas` | Registra nova venda |
| GET | `/vendas/{id}` | Busca venda por ID |

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

---

## 🗺️ Roadmap

- [x] CRUD de Produtos
- [x] Gestão de Categorias
- [x] Cadastro de Fornecedores
- [x] Registro de Vendas
- [x] Controle de Estoque
- [ ] Front-end em React *(em desenvolvimento)*
- [ ] Autenticação JWT
- [ ] Relatórios de vendas

---

## 👨‍💻 Autor

**Wenderson Carvalho de Araújo Mota**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=white)](https://linkedin.com/in/seu-linkedin)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white)](https://github.com/WendeNJ)
