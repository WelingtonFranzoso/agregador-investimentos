# Franzoso agregador de investimentos
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/WelingtonFranzoso/franzoso-agregador-de-investimentos/blob/main/LICENSE) 

# Sobre o projeto

Franzoso agregador de investimento é uma aplicação back-end, sendo uma aplicação REST para realizar CRUD de usuário, contas e ações da bolsa, com uso de DTO. Testes em JUnit5 e usando o Open Feign para consumir a API da Brapi para retornar os valores ações em tempo real. O banco de dados utilizado foi o MySQL em um container Docker.

## Modelo conceitual
![Modelo Conceitual](https://github.com/WelingtonFranzoso/franzoso-agregador-de-investimentos/blob/main/assets/modelo-conceitual.png?raw=true)

# Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Docker
- JUnit5
- Mockito
- Open Feign
- API Brapi (https://brapi.dev)
- Banco de dados: MySQL

# Como executar o projeto

## Back end
Pré-requisitos: 
Java 17
Maven
Docker
MySQL

```bash
# clonar repositório
git clone git@github.com:WelingtonFranzoso/franzoso-agregador-de-investimentos.git

# entrar na pasta do projeto back end
cd franzoso-agregador-de-investimentos

# executar o projeto
./mvnw spring-boot:run
```

# Autor

Welington Franzoso
https://www.linkedin.com/in/welington-franzoso-88a8301b9
