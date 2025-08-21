# 📘 Gerenciador de Tarefas — Full Stack 

Aplicação para gerenciamento de tarefas, desenvolvida como **desafio técnico**.  
Possui **backend em Spring Boot** e integração com banco de dados relacional (**H2 em memória para desenvolvimento**).

---

## 🎯 Objetivo
Permitir **cadastro, listagem, atualização e exclusão** de tarefas.  

### Recursos adicionais:
- ✅ **Paginação** (`page`, `size`)  
- ✅ **Ordenação** (por `status`, `data de criação` etc.)  
- ✅ **Busca textual simples** (`q`)  

---

## 🔧 Tecnologias utilizadas

### **Backend**
- Java **21**
- Spring Boot **3.x**
- Spring Data JPA + Hibernate
- Banco de dados **Oracle** 
- **MapStruct** (mapeamento DTO ↔ Entidade)
- **JUnit 5 + Mockito + Spring Test** (testes unitários e integração)
- Maven **3.9+**

### **Frontend**
- Angular 
- TypeScript
- CSS 

### **DevOps**
- Git (versionamento) - utilizar master


## 🗂 Modelo de Dados

**Tabela `tarefas`**

| Campo               | Tipo              | Descrição                                    |
|----------------------|------------------|----------------------------------------------|
| `id`                | Long (PK)        | Identificador único da tarefa                 |
| `titulo`            | String           | Título da tarefa                              |
| `descricao`         | String           | Descrição detalhada                           |
| `status`            | Enum             | PENDENTE, EM_ANDAMENTO, CONCLUIDA             |
| `data_criacao`      | LocalDateTime    | Data em que a tarefa foi criada               |
| `data_atualizacao`  | LocalDateTime    | Data da última atualização                    |
| `usuario_atualizacao` | String         | Usuário responsável pela última atualização   |

---

## 🚀 Como Executar

- ✅ **Rodar docker-compose.yaml na raiz do projeto para subir banco Oracle**
- ✅ **Acesse raiz do projeto e execute o comando docker-compose up**

### 🔹 1. Backend
```bash
cd backend
mvn spring-boot:run



