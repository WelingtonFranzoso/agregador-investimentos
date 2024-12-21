# Franzoso Agregador de Investimentos
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/WelingtonFranzoso/franzoso-agregador-de-investimentos/blob/main/LICENSE) 

# Sobre o projeto

Franzoso Agregador de Investimentos é uma aplicação backend que oferece uma API REST para realizar operações de CRUD de usuários, contas e ações da bolsa de valores. A aplicação faz uso de DTOs para gerenciar dados de forma eficiente e segura.

A API utiliza JUnit 5 para testes automatizados e OpenFeign para consumir dados em tempo real da API Brapi, fornecendo informações atualizadas sobre as ações da bolsa. O banco de dados utilizado é o MySQL, executado em um container Docker para facilitar o ambiente de desenvolvimento.

## Modelo conceitual
![Modelo Conceitual](https://github.com/WelingtonFranzoso/franzoso-agregador-de-investimentos/blob/main/assets/modelo-conceitual.png?raw=true)

# Funcionalidades
- Cadastro e gerenciamento de usuários: Permite a criação, leitura, atualização e exclusão de usuários.
- Gestão de contas de investimentos: Cada usuário pode ter várias contas de investimento, com CRUD completo.
- Cadastro de ações: O usuário pode cadastrar e manter um histórico das ações de interesse.
- Consulta de valores de ações em tempo real: Utilizando a API Brapi, o sistema consulta e retorna os valores atualizados das ações da bolsa.
- Persistência dos dados: Utiliza MySQL como banco de dados para armazenar informações de usuários, contas e ações.
- Testes automatizados: Inclui testes unitários com JUnit5 e mocks com Mockito para garantir a qualidade do código.
- API RESTful: A aplicação fornece uma API RESTful com endpoints para manipulação dos dados de usuários, contas e ações.

# Tecnologias utilizadas
- Java 17 - Linguagem de programação principal
- Spring Boot - Framework para desenvolvimento rápido de APIs
- JPA / Hibernate - ORM (Object-Relational Mapping) para interação com o banco de dados
- Maven - Gerenciador de dependências e build
- Docker - Containerização da aplicação
- JUnit 5 - Framework de testes unitários
- Mockito - Framework para mocks em testes
- OpenFeign - Cliente HTTP declarativo para comunicação com a API Brapi
- API Brapi - API para dados em tempo real sobre ações (Fonte: https://brapi.dev)
- MySQL - Banco de dados relacional

# Como executar o projeto

## Back end
### Pré-requisitos: 
- Java 17
- Maven
- Docker
- MySQL

```bash
# clonar repositório
git clone git@github.com:WelingtonFranzoso/franzoso-agregador-de-investimentos.git

# entrar na pasta do projeto back end
cd franzoso-agregador-de-investimentos

# executar o projeto
./mvnw spring-boot:run

# configuração do banco de dados
docker-compose up -d

# testes com JUnit
./mvnw test
```

# Autor

Welington Franzoso
https://www.linkedin.com/in/welington-franzoso-88a8301b9
