<h1 style="text-align: center"> Desafio Bravi Backend </h1>

## Tecnologias
- Java 17
- Gradle
- Spring
    - Web
    - Validation
    - Data JPA
    - Cloud
- Rest
- Lombok
- MapStruct
- MySQL
- Docker

## Para rodar os projetos siga os comandos a seguir
-> Dentro do diretório **contact-list-api/src/main/docker** no seu terminal, 
rode o seguinte comando para que seja criado um container do banco de dados usado ( MySQL ):
```
docker-compose up
```

-> Após isso você precisará rodar os projetos **balanced-brackets-api**, 
**contact-list-api** e **city-weather-client** que podem ser executados 
via IDE ou pela seguinte linha de comando:


na raiz do projeto, por exemplo **/balanced-brackets-api** no caso do projeto **balanced-brackets-api**
```
gradle bootRun
```

---

Após rodar os projetos você conseguirá fazer os testes, 
cada projeto está rodando em uma porta.
<br>
Para facilitar, coloquei os arquivos:
- bravi-test-backend.postman_collection.json 
- Local.postman_environment.json

para você importar na sua máquina e já começar os testes
<br><br><br>