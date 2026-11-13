
# 🛠️ TaskForge

> API de gerenciamento de tarefas com autenticação JWT, validação e tratamento de erros padronizado.

🚀 **[App no ar](https://taskforge-web-template-49i.pages.dev)** · 📖 **[Swagger no ar](https://taskforge-ajfj.onrender.com/swagger-ui/index.html)**



![Tela do TaskForge]
<img width="700" alt="login" src="https://github.com/user-attachments/assets/84165926-6bd4-426c-b63e-e66982421a11" />

## Sobre o projeto

O TaskForge é uma aplicação full stack para gerenciar tarefas: cria, lista, atualiza e remove tarefas, com filtro de urgentes (pendentes de prioridade 1).
A API REST é protegida por autenticação com token, valida os dados de entrada e devolve erros em um formato padronizado (ex.: 404 com status, mensagem e campos).
Está em produção, com backend e banco hospedados na nuvem e frontend publicado na edge, com documentação interativa via Swagger.

## Stack

**Java** · **Spring Boot** · **React** · **PostgreSQL** · **Docker** · **Render** (backend) · **Cloudflare** (frontend)

> ⏳ O backend roda no plano gratuito do Render: a primeira requisição pode levar cerca de 50s para "acordar" o servidor.
