# ⚠️🚧 EM CONSTRUÇÃO 🚧⚠️

> Este projeto ainda está em desenvolvimento. Algumas funcionalidades podem não estar completas ou estáveis. Acompanhe as atualizações!
# Supermercado Java

Este projeto é um sistema para gerenciamento de estoque, vendas e produtos de um supermercado, desenvolvido utilizando **Java** com o Spring Framework. O objetivo é oferecer funcionalidades básicas como cadastro de produtos, fornecedores, categorias, vendas, entre outras.

## Tecnologias Utilizadas

- **Java** (JDK 11 ou superior)
- **Spring Boot**
- **Spring Data JPA** (para persistência de dados)
- **H2 Database** (banco de dados em memória para desenvolvimento)
- **Maven** (para gerenciamento de dependências e build)
- **DTO** (Data Transfer Object) para comunicação eficiente entre camadas
- **JPA / Hibernate** (para mapeamento objeto-relacional)

##  Status do Projeto

Este projeto está em **produção** para a parte **back-end** e ainda em **desenvolvimento ativo**. Algumas funcionalidades podem estar sendo ajustadas ou melhoradas, mas o sistema já está funcional para as operações principais de um supermercado, como:

- Cadastro de produtos
- Gestão de categorias de produtos
- Cadastro de fornecedores
- Registro de vendas e itens vendidos
- Gerenciamento de estoque

###  **Front-End**

O **front-end** do sistema **ainda não está em produção**. A interface gráfica e a integração com o back-end ainda estão sendo desenvolvidas, e o foco atual é garantir a estabilidade e a funcionalidade do back-end.

## Estrutura do Projeto

O projeto é estruturado da seguinte maneira:

- **Entities**: Classes que representam as tabelas no banco de dados.
- **DTO**: Objetos de transferência de dados usados para comunicação entre camadas.
- **Repository**: Interfaces para acesso ao banco de dados.
- **Service**: Contém a lógica de negócios e manipulação dos dados.
- **Controller**: Contém as rotas (endpoints REST) que expõem a API.

##  Como Rodar o Projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/WendeNJ/Supermercado-java.git
