# 📄 Consulta de Crédito API

API para consulta de créditos associada a números de NFS-e.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.4
- Docker Compose
- PostgreSQL (via Docker Compose)
- Swagger OpenAPI (documentação automática)

---

## 📦 Como Subir o Projeto

Este projeto deve ser clonado no mesmo diretório do projeto frontend para que o `docker-compose` funcione corretamente.

1. Clone o repositório da API e do Frontend no mesmo diretório:

```bash
git clone https://github.com/seu-usuario/consulta-credito.git
git clone https://github.com/seu-usuario/consulta-credito-frontend.git
```

2. Dentro da pasta onde estão os dois projetos, suba o ambiente:

```bash
docker-compose up --build
```

3. A API estará disponível em:

```
http://localhost:8081
```

4. O Frontend estará disponível em:

```
http://localhost:4200
```

4. O PostgreSQL estará disponível na porta:

```
5432
```

---

## 🛢️ Banco de Dados

- Sistema: PostgreSQL

- Host: consulta-credito-db

- Porta: 5432

- Database: consulta_credito

- Usuário: postgres

- Senha: postgres

---

## 📚 Endpoints Disponíveis

### 1. Obter todos os créditos por número de NFS-e

- **GET** `/api/creditos/{numeroNfse}`

### 2. Obter crédito por número de crédito

- **GET** `/api/creditos/credito/{numeroCredito}`

---

## 📖 Documentação Swagger

```
http://localhost:8081/swagger-ui.html
```

---

## 🔧 Configurações Importantes

- **CORS:** A API já aceita requisições de `http://localhost:4200`.

---

## 🛠️ Build Manual (sem Docker)

```bash
./mvnw clean install
./mvnw spring-boot:run
```

---

## 📄 Licença

Este projeto está sob licença [MIT](LICENSE).

> Feito por [Yasmin de Araújo Arantes Brandão](https://github.com/yasminaraujoarantes)
