---

### Grupo:
- NÍCOLAS BORBA PEREIRA
- ELIAS ENNS
- MICHEL ALMEIDA DA ROSA
- JULIANO DA SILVA SILVA

### Projeto:

API REST de conferência de vazamento de dados:

### Casos de uso:

1. **Verificar se um e-mail foi vazado**
2. **Acessar e manipular a lista de vazamentos de dados**

### Recursos

1. `emails`
2. `vazamentos`

---

### Endpoints

#### 1. Verificar se um e-mail foi vazado

| Descrição | URI | Método HTTP | Corpo | Resposta Esperada | Erros esperados |
| --- | --- | --- | --- | --- | --- |
| Verificar vazamento de um e-mail | `/emails/{email-id}/vazamentos` | `GET` | Vazio | `200 OK`, lista de vazamentos para o e-mail | `404 Not Found` - e-mail não encontrado ou não possui vazamentos. |
| Adicionar um e-mail à lista de monitoramento | `/emails` | `POST` | `{ "email": "usuario@dominio.com" }` | `201 Created` - e-mail adicionado | `400 Bad Request` - e-mail inválido ou já existente. |
| Atualizar informações do e-mail | `/emails/{email-id}` | `PUT` | `{ "email": "novo-email@dominio.com" }` | `200 OK` - e-mail atualizado | `404 Not Found` - e-mail não encontrado. |
| Deletar um e-mail da lista de monitoramento | `/emails/{email-id}` | `DELETE` | Vazio | `200 OK` - e-mail deletado | `404 Not Found` - e-mail não encontrado. |

---

#### 2. Acessar e manipular a lista de vazamentos de dados

| Descrição | URI | Método HTTP | Corpo | Resposta Esperada | Erros esperados |
| --- | --- | --- | --- | --- | --- |
| Listar todos os vazamentos registrados | `/vazamentos` | `GET` | Vazio | `200 OK`, lista de vazamentos | Nenhum. |
| Ver detalhes de um vazamento específico | `/vazamentos/{vazamento-id}` | `GET` | Vazio | `200 OK`, informações do vazamento | `404 Not Found` - vazamento não encontrado. |
| Registrar um novo vazamento | `/vazamentos` | `POST` | `{ "fonte": "site-exposto.com", "data": "2024-10-01", "dados": ["email", "senha"] }` | `201 Created` - vazamento registrado | `400 Bad Request` - dados do vazamento inválidos. |
| Atualizar informações de um vazamento | `/vazamentos/{vazamento-id}` | `PUT` | `{ "fonte": "novo-site.com", "data": "2024-10-02" }` | `200 OK` - vazamento atualizado | `404 Not Found` - vazamento não encontrado. |
| Deletar um vazamento | `/vazamentos/{vazamento-id}` | `DELETE` | Vazio | `200 OK` - vazamento deletado | `404 Not Found` - vazamento não encontrado. |

---

### Resumo dos Status Codes Comuns:
- **200 OK**: Operação bem-sucedida.
- **201 Created**: Recurso criado com sucesso.
- **400 Bad Request**: Dados inválidos.
- **404 Not Found**: Recurso não encontrado.

Essa estrutura permite a verificação de vazamentos de dados de e-mails e o gerenciamento dos vazamentos registrados no sistema.