PROJETO: Sistema Web de Login com React + Spring Boot + Docker

DESCRIÇÃO
---------
Este projeto é um sistema web completo de autenticação com funcionalidades de cadastro, login, gerenciamento de usuários e troca de senha.

TECNOLOGIAS UTILIZADAS
-----------------------
- Frontend: React + Vite + MUI + Formik + Yup
- Backend: Java Spring Boot + Spring Security
- Banco de Dados: MySQL (via Docker)
- Docker + Docker Compose
- Swagger para documentação da API

FUNCIONALIDADES
---------------
- Cadastro de usuários com nome, e-mail, senha, CPF e perfil (Usuário ou Administrador)
- Login com autenticação via JWT
- Troca de senha pelo próprio usuário
- Listagem e exclusão de usuários (restrito a administradores)
- Tela inicial com saudação ("Hola Mundo")
- Validações para dados inválidos ou duplicados

COMO RODAR O PROJETO
---------------------
1. Tenha [Docker](https://docs.docker.com/engine/install/) e [Docker Compose](https://docs.docker.com/compose/install/) instalados

2. Clone o repositório:
   `git clone https://github.com/giovannadequi4/login-spring-react.git`

3. Crie o arquivo `.env` na raiz com o seguinte conteúdo:

``` bash
# Database
DB_ROOT_PASSWORD=senhadobanco
DB_DATABASE_NAME=projeto
DB_USER=giovannadequi
DB_PASSWORD=senhadobanco
DB_PORT_LOCAL=3307
DB_PORT_DOCKER=3306
IP=mysql

# Web app
BACKEND_PORT_DOCKER=8081
BACKEND_PORT_LOCAL=8081
FRONTEND_PORT_DOCKER=5173
FRONTEND_PORT_LOCAL=5173

# Internal users
SYS_USER=user
SYS_PASSWD=123
SYS_ADM_USER=admin
SYS_ADM_PASSWD=admin123
```

4. Subir os containers:
   docker-compose up --build

5. Acessar a aplicação:
   - Frontend: http://localhost:5173/login
   - Backend (Swagger): http://localhost:8081/swagger-ui/index.html

SEGURANÇA
---------
- Autenticação e autorização com Spring Security
- Tokens JWT protegendo as rotas
- Controle de acesso por perfil (Usuário/Admin)

DIFERENCIAIS
-------------------------
- Validações com Formik + Yup
- Integração com Swagger para documentação automática da API
- Banco de dados em container Docker (sem instalação local)
- Deploy local simplificado com Docker Compose

AUTOR
-----
Giovanna Brocker - https://www.linkedin.com/in/giovanna-dequi




