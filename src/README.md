# 📚 Gestão Escolar – Processo Seletivo DTI

Sistema fullstack desenvolvido como parte do **processo seletivo da DTI**, com o objetivo de gerenciar alunos, notas, frequência e gerar relatórios acadêmicos.

O projeto é composto por:
- **Backend** em Java com Spring Boot
- **Frontend** em React.js

---

## 🚀 Tecnologias Utilizadas

### Backend
- Java 17
- Spring Boot
- Maven
- Armazenamento **em memória** (sem banco de dados)

### Frontend
- React.js
- JavaScript (ES6+)
- Fetch API
- CSS puro

---

## ▶️ Instruções para Executar o Sistema

### 🔵 Backend (Spring Boot)

1. Acesse a pasta do backend:
```bash
   cd gestaoEscolar


  
  2. 
./mvnw spring-boot:run

  3. 
A API ficará disponível em: http://localhost:8080

⚠️ Observação:
Os dados são mantidos apenas em memória e serão perdidos ao reiniciar a aplicação.

📌 Premissas Assumidas

Cada aluno possui 5 disciplinas fixas

As notas variam de 0 a 10

A frequência varia de 0% a 100%

Um aluno é considerado aprovado se:

Média ≥ 7

Frequência ≥ 75%

Não há persistência em banco de dados

Os dados são armazenados temporariamente em memória

O sistema não possui autenticação


🧠 Decisões de Projeto

Armazenamento em memória para simplificar a solução

Separação clara das responsabilidades:

Controller

Service

Uso de DTOs para respostas da API

Validações de dados no frontend

Organização do frontend por componentes reutilizáveis

Atualização dinâmica da interface após operações CRUD

🔗 Rotas da API

📄 Listar alunos 

GET http://localhost:8080/alunos

➕ Cadastrar aluno
POST http://localhost:8080/alunos

Body EX :
 json 
{
  "nome": "Maria",
  "mediaDisciplina1": 7,
  "mediaDisciplina2": 8,
  "mediaDisciplina3": 6,
  "mediaDisciplina4": 9,
  "mediaDisciplina5": 10,
  "frequencia": 80
}

✏️ Atualizar aluno
PUT http://localhost:8080/alunos/{id}

🗑️ Excluir aluno 
DELETE http://localhost:8080/alunos/{id}

📊 Média da turma por disciplina
GET http://localhost:8080/alunos/media-turma

⚠️ Alunos com frequência abaixo de 75%
GET http://localhost:8080/alunos/frequenciaBaixa

📎 Observações Importantes

Este projeto não utiliza banco de dados

O foco está na lógica de negócio e integração frontend/backend

Ideal para avaliação de arquitetura, organização e boas práticas



