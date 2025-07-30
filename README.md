# 📦 Projeto Delivery API

API REST para gerenciamento de usuários com roles, endereços, pedidos e itens de um sistema de delivery.

## 📋 Descrição

Este projeto tem como objetivo oferecer endpoints seguros e organizados para:
- Cadastro e autenticação de usuários
- Gerenciamento de endereços
- Criação e acompanhamento de pedidos
- Visualização de itens e preços

O sistema possui controle de acesso baseado em papéis (`ADMIN` e `CLIENTE`) e foi estruturado utilizando princípios de arquitetura limpa, com divisão entre controllers, services, use cases e gateways.

---

## ⚙️ Tecnologias utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **JWT (Autenticação)**
- **DTO (Data Transfect Object)**
- **Flyway**
- **MySQL**
- **Docker & Docker Compose**
- **Swagger (Documentação dos endpoints)**

---
## ▶️ Como rodar o projeto?

Para executar este projeto localmente, é necessário ter o **Docker** instalado na sua máquina.

1. Clonar o repositório
```bash
   git clone https://github.com/patrickxbs/delivery_api_spring.git
```
2. Construir a imagem e iniciar os containers
```bash
  docker build -t patrick/delivery .
  docker-compose up -d
```
3. Acessar a documentação da API
```bash
  http://localhost:8080/docs-delivery.html
```
   
