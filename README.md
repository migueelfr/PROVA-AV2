# 🚀 API de Produtos e Categorias - Spring Boot + JWT + Monitoramento

Este projeto é uma API RESTful completa para gerenciamento de produtos e categorias, com autenticação JWT, monitoramento com Prometheus e Grafana, testes, documentação Swagger e deploy via Docker.

---

## 📚 Sumário
- [Funcionalidades](#funcionalidades)
- [Tecnologias](#tecnologias)
- [Como rodar localmente](#como-rodar-localmente)
- [Monitoramento (Prometheus & Grafana)](#monitoramento-prometheus--grafana)
- [Endpoints principais](#endpoints-principais)
- [Deploy em nuvem](#deploy-em-nuvem)
- [Prints dos dashboards](#prints-dos-dashboards)
- [Próximos passos](#próximos-passos)

---

## ✨ Funcionalidades
- Cadastro e login de usuários com autenticação JWT
- CRUD de produtos e categorias
- Controle de acesso por roles (USER/ADMIN)
- Documentação automática com Swagger
- Monitoramento em tempo real com Prometheus e Grafana
- Testes unitários e de carga
- Deploy fácil com Docker

---

## 🛠️ Tecnologias
- **Java 21 + Spring Boot 3**
- Spring Security, JWT, BCrypt
- Spring Data JPA + H2 Database
- Springdoc OpenAPI (Swagger)
- Spring Boot Actuator
- Prometheus + Grafana
- Docker e Docker Compose
- JUnit 5, Mockito, JMeter

---

## 🚀 Como rodar localmente

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/seu-repo.git
cd seu-repo

# Compile o projeto
mvn clean package -DskipTests

# Rode com Docker Compose
docker-compose up -d
```

Acesse:
- API: [http://localhost:8080](http://localhost:8080)
- Swagger: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- Prometheus: [http://localhost:9090](http://localhost:9090)
- Grafana: [http://localhost:3000](http://localhost:3000) (login: admin/admin)

---

## 📊 Monitoramento (Prometheus & Grafana)

- O Prometheus coleta métricas da aplicação expostas pelo endpoint `/actuator/prometheus`.
- O Grafana exibe dashboards em tempo real com uso de CPU, memória, requisições HTTP, etc.

**Exemplo de métricas que você pode consultar no Prometheus:**
- `process_cpu_usage`
- `jvm_memory_used_bytes{area="heap"}`
- `http_server_requests_seconds_count`
- `hikaricp_connections_active`

---

## 🔗 Endpoints principais

- **Autenticação**
  - `POST /auth/register` - Cadastro de usuário
  - `POST /auth/login` - Login e obtenção do token JWT

- **Produtos**
  - `GET /produtos` - Listar produtos (USER, ADMIN)
  - `POST /produtos` - Criar produto (ADMIN)
  - `PUT /produtos/{id}` - Atualizar produto (ADMIN)
  - `DELETE /produtos/{id}` - Remover produto (ADMIN)

- **Categorias**
  - `GET /categorias` - Listar categorias (USER, ADMIN)
  - `POST /categorias` - Criar categoria (ADMIN)
  - `PUT /categorias/{id}` - Atualizar categoria (ADMIN)
  - `DELETE /categorias/{id}` - Remover categoria (ADMIN)

- **Swagger:**  
  [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## ☁️ Deploy em nuvem

Você pode hospedar facilmente no [Render](https://render.com/) ou [Railway](https://railway.app/) usando o Dockerfile já pronto.

**Passos básicos:**
1. Suba o projeto para o GitHub.
2. Crie um novo serviço Web no Render/Railway.
3. Conecte o repositório e escolha o ambiente Docker.
4. Pronto! Sua API estará disponível em uma URL pública.

---

## 🖼️ Prints dos dashboards

Adicione aqui prints do Grafana, Prometheus e Swagger para ilustrar o monitoramento e a documentação da API:

```markdown
![Swagger UI](prints/swagger.png)
![Prometheus](prints/prometheus.png)
![Dashboard do Grafana](prints/grafana-dashboard.png)
```

> **Dica:** Crie uma pasta chamada `prints` no seu projeto e salve as imagens lá.

---

## 🎯 Próximos passos

- Implementar refresh tokens
- Adicionar rate limiting
- Implementar auditoria de logs
- Configurar CI/CD
- Adicionar testes de integração
- Implementar cache Redis

---

**Desenvolvido para AV2 - Autenticação e Autorização JWT**  
