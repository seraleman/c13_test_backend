# Books_test_C13

## Tabla de contenido

1. [Descripción](#descripción)
2. [Diagrama](#diagrama)
3. [Tecnología](#tecnología)
4. [Arquitectura](#arquitectura)
5. [Despliegue](#despliegue)
6. [Endpoints](#endpoints)
7. [Autor](#autor)

## Descripción

Este microservicio sirve para gestionar libros. Se puede crear, listar todos los libros o por id, actualizar y eliminar. Es parte del test para C13.

## Diagrama

```
├── src
│   └── main
│       └── java
│           ├── ...
│               └── pruebac13
│                   ├── components
│                       ├── book
│                           ├── services
│                               ├── BookServiceImpl.java
│                               └── IBookService.java
│                           ├── Book.java
│                           ├── BookRestController.java
│                           └── IBookDao.java
│                   ├── helpers
│                       └── response
│                           ├── IResponse.java
│                           └── ResponseImpl.java
|                   └── Pruebac13Application.java
│           └── resources
|               ├── static
|                   └── images ...
|               └── application.properties
├── Dockerfile
├── pom.xml
├── ...
└── README.md
```

## Tecnología

- Java
- SpringBoot
- MongoDB

## Arquitectura

![Image text](/src/main/resources/static/arquitectura.png)

## Despliegue

### Base de Datos

La base de datos se encuentra desplegada en la nube en Mongo Atlas, informo credenciales por si se desea revisar persistencia:

`mongodb+srv://seraleman:pruebac13@bookms.w04gh.mongodb.net/books?retryWrites=true&w=majority`.

### Microservicio

El microservicio está desplegado en Heroku, se puede acceder a él en la siguiente URL [https://test-c13-backend.herokuapp.com](https://test-c13-backend.herokuapp.com). Para su uso es necesario disponer de un software como postman o crear un componente frontend que lo consuma.

![Image text](/src/main/resources/static/despliegue.png)

## Endpoints

A continuación enuncio los endpoints para su prueba con evidencia del resultado:

- Listar todos los libros:

`https://test-c13-backend.herokuapp.com/book/`

_Verbo Get._

![Image text](/src/main/resources/static/listarTodos.png)

- Listar libro por id:

`https://test-c13-backend.herokuapp.com/book/<id>`

_Verbo Get._

![Image text](/src/main/resources/static/listarPorId.png)

- Crear libro:

`https://test-c13-backend.herokuapp.com/book/`

_Verbo Post._

_Se debe pasar el objeto libro con sus respectivos campos (name, description, author, genre)._

![Image text](/src/main/resources/static/crear.png)

- Actualizar libro por id:

`https://test-c13-backend.herokuapp.com/book/<id>`

_Verbo Put._

_Se debe pasar el objeto libro con sus respectivos campos actualizados (name, description, author, genre)._

![Image text](/src/main/resources/static/actualizar.png)

- Eliminar libro por id:

`https://test-c13-backend.herokuapp.com/book/<id>`

_Verbo Delete._

![Image text](/src/main/resources/static/eliminarPorId.png)

## Autor

[Sergio Manrique](https://www.linkedin.com/in/sergiomanrique-adsi/)
