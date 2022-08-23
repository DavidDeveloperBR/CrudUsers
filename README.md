# CrudUsers
Prova de conceito para Junior em Spring Boot

### Request

POST: `http://localhost:8085/api/drivers`

### Response

{
    "timestamp": "2022-08-23T21:23:26.557+00:00",
    "status": 201,
    "error": "Created",
    "message": "Usuário cadastrado com sucesso",
    "path": "/api/users"
}

### Request

GET: `http://localhost:8085/api/drivers/{id}`

### Response

{
    "nome": "David",
    "sobrenome": "Rodrigues",
    "email": "david@mail.com",
    "ativo": true
}

### Request

DELETE: `http://localhost:8085/api/drivers/{id}`

### Response

Status: 204 No Content

### Request

PATCH: `http://localhost:8085/api/drivers/{id}`

{
  "nome": "Fulano"
  "email": "fulano@hotmail.com"
}

### Response

Status: 204 No Content



