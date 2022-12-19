# Web API

**Contrato API**

Swagger: http://localhost:8080/swagger-ui/index.html#/
````
ADMIN

###
GET http://localhost:8080/api/escola/admin

###
GET http://localhost:8080/api/escola/admin/{{cpf}}

###
POST http://localhost:8080/api/escola/admin/criaAdmin

###
PUT http://localhost:8080/api/escola/admin/edita/{{cpf}}

###
DELETE http://localhost:8080/api/escola/admin/delete/{{cpf}}
````

````
ALUNO

###
GET http://localhost:8080/api/escola/aluno

###
GET http://localhost:8080/api/escola/aluno/{{cpf}}

###
POST http://localhost:8080/api/escola/aluno/criaAluno

###
PUT http://localhost:8080/api/escola/aluno/edita/{{cpf}}
````

````
PROFESSOR

###
GET http://localhost:8080/api/escola/professor

###
GET http://localhost:8080/api/escola/professor/{{cpf}}

###
POST http://localhost:8080/api/escola/professor/criaProfessor

###
PUT http://localhost:8080/api/escola/professor/edita/{{cpf}}

###
DELETE http://localhost:8080/api/escola/professor/delete/{{cpf}}
````

````
DISCIPLINA

###
GET http://localhost:8080/api/escola/disciplina

###
GET http://localhost:8080/api/escola/disciplina/{{id}}

###
POST http://localhost:8080/api/escola/disciplina/criaDisciplina

###
PUT http://localhost:8080/api/escola/disciplina/editaDisciplina/{{id}}

###
DELETE http://localhost:8080/api/escola/disciplina/delete/{{id}}
````

````
TURMA

###
GET http://localhost:8080/api/escola/turma

###
GET http://localhost:8080/api/escola/turma/{{id}}}

###
POST http://localhost:8080/api/escola/turma/criaTurma

###
PUT http://localhost:8080/api/escola/turma/edita/{{id}}

###
DELETE http://localhost:8080/api/escola/turma/delete/{{id}}
````

````
Responsavel

###
GET http://localhost:8080/api/escola/responsavel

###
GET http://localhost:8080/api/escola/responsavel/{{cpf}}

###
POST http://localhost:8080/api/escola/responsavel/criaResponsavel

###
PUT http://localhost:8080/api/escola/responsavel/edita/{{cpf}}
````

````
Falta

###
GET http://localhost:8080/api/escola/falta

###
GET http://localhost:8080/api/escola/falta/{{id}}

###
GET http://localhost:8080/api/escola/falta/aluno/reprovado

###
GET http://localhost:8080/api/escola/falta/aluno/calculoFaltas

###
POST http://localhost:8080/api/escola/falta/criaFalta

###
POST http://localhost:8080/api/escola/falta/criaPresenca

###
PUT http://localhost:8080/api/escola/falta/edita/{{id}}

````

````
Nota

###
GET http://localhost:8080/api/escola/nota/calculoMedia

###
GET http://localhost:8080/api/escola/nota/mediaAluno

###
POST http://localhost:8080/api/escola/nota/criaNota

````

````
Forum

###
GET http://localhost:8080/api/escola/forum

###
GET http://localhost:8080/api/escola/forum/{{id}}

###
POST http://localhost:8080/api/escola/forum/criaForum

````

````
Aula

###
GET http://localhost:8080/api/escola/aula

###
GET http://localhost:8080/api/escola/aula/{{id}}

###
POST http://localhost:8080/api/escola/aula/criaAula

###
PUT http://localhost:8080/api/escola/aula/edita/{{id}}

###
DELETE http://localhost:8080/api/escola/aula/delete/{{id}}
````