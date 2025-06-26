# 🚀 API de Produtos e Categorias - Spring Boot + JWT + Monitoramento

Este projeto é uma API RESTful completa para gerenciamento de produtos e categorias, com autenticação JWT, monitoramento com Prometheus e Grafana, testes, documentação Swagger e deploy via Docker.

---

## 📚 Sumário
- [Funcionalidades](#funcionalidades)
- [Tecnologias](#tecnologias)
- [Como rodar localmente](#como-rodar-localmente)
- [Monitoramento (Prometheus & Grafana)](#monitoramento-prometheus--grafana)
- [Endpoints principais](#endpoints-principais)
- [Como o projeto foi construído](#como-o-projeto-foi-construido)
- [Prints dos dashboards](#prints-dos-dashboards)

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
- **Apache Maven** (gerenciamento de dependências e build)

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

## 🛠️ Como o projeto foi construído

- **Apache Maven:** Utilizado para gerenciar as dependências do projeto e facilitar o processo de build e execução. O arquivo `pom.xml` define todas as bibliotecas necessárias, como Spring Boot, JWT, JPA, Actuator, Prometheus, Grafana, entre outras.

- **Estrutura em camadas:**
  - **Controller:** Responsável por receber as requisições HTTP e retornar as respostas.
  - **Service:** Onde fica a lógica de negócio da aplicação.
  - **Repository:** Comunicação com o banco de dados usando Spring Data JPA.
  - **Model:** Entidades que representam as tabelas do banco de dados.
  - **DTO:** Objetos para transferência de dados entre as camadas.
  - **Security:** Configuração de autenticação JWT e roles de usuário.
  - **Config:** Outras configurações, como Swagger e monitoramento.

- **Autenticação JWT:**
  - Implementada usando Spring Security e JWT. O usuário faz login, recebe um token e utiliza esse token para acessar os endpoints protegidos.

- **Monitoramento:**
  - O Spring Boot Actuator expõe métricas no endpoint `/actuator/prometheus`.
  - O Prometheus coleta essas métricas e o Grafana exibe dashboards visuais.

- **Documentação:**
  - O Swagger está disponível em `/swagger-ui.html` para testar e visualizar todos os endpoints da API.

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

**Desenvolvido para AV2 - Autenticação e Autorização JWT**  

## 🎯 Critérios da AV2 Atendidos

- ✅ **Autenticação JWT**: Implementada com geração e validação de tokens
- ✅ **Spring Security**: Configurado com filtros JWT
- ✅ **Testes Unitários**: JUnit 5 com Mockito
- ✅ **Testes de Carga**: JMeter configurado
- ✅ **Documentação**: OpenAPI/Swagger implementado
- ✅ **Monitoramento**: Actuator + Prometheus + Grafana
- ✅ **Deploy**: Docker + Docker Compose
- ✅ **Integração**: Endpoints CRUD protegidos com JWT

## 🚀 Próximos Passos

1. **Implementar refresh tokens**
2. **Adicionar rate limiting**
3. **Implementar auditoria de logs**
4. **Configurar CI/CD**
5. **Adicionar testes de integração**
6. **Implementar cache Redis**

---

**Desenvolvido para AV2 - Autenticação e Autorização JWT** 🎓 