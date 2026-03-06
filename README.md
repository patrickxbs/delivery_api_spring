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
## Deploy na AWS

**A aplicação foi deployada na AWS utilizando:**
* EC2 para execução da API em container Docker
* RDS (MySQL) como banco de dados
* Docker Hub para armazenamento da imagem
* GitHub Actions para pipeline CI/CD (build, push e deploy automático)

A infraestrutura foi organizada utilizando VPC, subnets públicas e privadas, além de Security Groups para controle de acesso entre os serviços.

### Diagrama da Arquitetura
<img width="1334" height="657" alt="image" src="https://github.com/user-attachments/assets/22583471-b633-446e-ae25-ad54eaf4854e" />

* Atualmente a aplicação não está em execução para evitar custos desnecessários na infraestrutura da AWS.

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
   
