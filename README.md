# PROJETO: Sistema Web de Login com React + Spring Boot + Docker

[🇧🇷 Português](#pt) | [🇬🇧 English](#en)

![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

---

## 🇧🇷 <a name="pt"></a>Português
DESCRIÇÃO
---------
Este projeto é um sistema web completo de autenticação com funcionalidades de cadastro, login, gerenciamento de usuários e troca de senha.

TECNOLOGIAS UTILIZADAS
-----------------------
- Frontend: React + Vite + MUI + Yup
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
- Validações com Yup
- Integração com Swagger para documentação automática da API
- Banco de dados em container Docker (sem instalação local)
- Deploy local simplificado com Docker Compose

AUTOR
-----
Giovanna Brocker - https://www.linkedin.com/in/giovanna-dequi

---

## 🇬🇧 <a name="en"></a>English

This project is a complete web authentication system with features for user registration, login, user management, and password change.

TECHNOLOGIES USED
-----------------

- Frontend: React + Vite + MUI + Yup
- Backend: Java Spring Boot + Spring Security
- Database: MySQL (via Docker)
- Docker + Docker Compose
- Swagger for API documentation

FEATURES
--------
- User registration with name, email, password, CPF, and profile (User or Administrator)
- Login with JWT authentication
- Password change by the user themselves
- User listing and deletion (restricted to administrators)
- Welcome screen with greeting ("Hola Mundo")
- Validations for invalid or duplicated data

HOW TO RUN THE PROJECT
----------------------
1. Install Docker and Docker Compose
2. Clone the repository:
   `` git clone https://github.com/giovannadequi4/login-spring-react.git
    

3. Create the .env file at the root with the following content:
    
``` bash
   # Database
   DB_ROOT_PASSWORD=databasepassword
   DB_DATABASE_NAME=project
   DB_USER=giovannadequi
   DB_PASSWORD=databasepassword
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
4. Start the containers:
  ``  docker-compose up --build ``

5. Access the application:
   - Frontend: http://localhost:5173/login
   - Backend (Swagger): http://localhost:8081/swagger-ui/index.html

SECURITY
--------
- Authentication and authorization with Spring Security
- JWT tokens protecting the routes
- Access control by profile (User/Admin)

DIFFERENTIATORS
---------------
- Validations with Yup
- Integration with Swagger for automatic API documentation
- Database in a Docker container (no local installation required)
- Simplified local deployment with Docker Compose

AUTHOR
------
Giovanna Brocker - https://www.linkedin.com/in/giovanna-dequi
