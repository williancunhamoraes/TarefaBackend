Gerenciador de Tarefas — Full Stack
Aplicação full stack para gerenciamento de tarefas, desenvolvida como desafio técnico.
Possui backend em Spring Boot, frontend em Angular e integração com banco de dados relacional (H2 em memória para desenvolvimento).

🎯 Objetivo
Permitir cadastro, listagem, atualização e exclusão de tarefas.
Recursos adicionais:

Paginação (page, size)

Ordenação (por status, data de criação etc.)

Busca textual simples (q)

🔧 Tecnologias utilizadas
Backend
Java 17

Spring Boot 3.x

Spring Data JPA + Hibernate

H2 (desenvolvimento/testes) / (Oracle em produção)

MapStruct (mapeamento DTO ↔ Entidade)

JUnit 5 + Mockito + Spring Test (testes unitários e integração)

Maven 3.9+

Frontend
Angular 16+

TypeScript

CSS puro

DevOps
Git (versionamento)

Jenkins (pipeline de CI/CD)

📂 Estrutura do Projeto
swift
Copiar
Editar
backend/
  src/main/java/br/com/tarefas/
    api/
      TarefaControle.java
      TratadorErros.java
      dto/
        TarefaEntradaDTO.java
        TarefaRespostaDTO.java
      mapper/
        TarefaMapper.java
    dominio/
      Tarefa.java
      StatusTarefa.java
    repositorio/
      TarefaRepositorio.java
      TarefaEspecificacoes.java
    servico/
      TarefaServico.java
  src/test/java/br/com/tarefas/
    api/TarefaControleTest.java
    servico/TarefaServicoTest.java
    repositorio/TarefaRepositorioTest.java
    api/mapper/TarefaMapperTest.java

frontend/
  src/app/
    services/tarefa.service.ts
    components/
      tarefa-lista/
      tarefa-form/
🗂 Modelo de Dados
Tabela tarefas

id (PK)

titulo

descricao

status (PENDENTE, EM_ANDAMENTO, CONCLUIDA)

data_criacao

data_atualizacao

usuario_atualizacao

🚀 Como executar
1. Backend
bash
Copiar
Editar
cd backend
mvn spring-boot:run
API → http://localhost:8080/api/tarefas

Console H2 → http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:db_tarefas

User: sa | Password: (vazio)

2. Frontend
bash
Copiar
Editar
cd frontend
npm install
ng serve
UI → http://localhost:4200

📡 Endpoints principais
GET /api/tarefas?page=0&size=10&sort=dataCriacao,desc&q=texto&status=PENDENTE

GET /api/tarefas/{id}

POST /api/tarefas

PUT /api/tarefas/{id}

DELETE /api/tarefas/{id}

Exemplo POST:

json
Copiar
Editar
{
  "titulo": "Estudar desafio técnico",
  "descricao": "Criar backend e frontend",
  "status": "PENDENTE",
  "usuarioAtualizacao": "joao.silva"
}
