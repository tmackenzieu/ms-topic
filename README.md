#  App Topic 
 Microservice Springboot for sending messages to topics Google Cloud


 ## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

_Que cosas necesitas para instalar el software y como instalarlas_

```
Java 11
Maven
```

### Instalación 🔧

* Instalar dependencias con el comando ```mvn clean install``` 


## Uso 📦

* Crear en Google Cloud, una cuenta, crear un tópico y un subscriptor _
* Ir a la carpeta resources -> `application.yml` 
  * Luego modificar  los siguientes valores con los que creaste el tópico. 
    * project-id: "{{project_id}}"
    * topic-topic_name: "{{topic_name}}"

Ejecutar el proyecto, este se levantará en localhost:8080.

Curl para enviar mensaje a un tópico de ejemplo:

```curl
curl --location --request POST 'http://localhost:8080/send/message' \
--header 'Content-Type: application/json' \
--data-raw '{
    "message": "Hello Taby"
}'
```


## Construido con 🛠️

* [Springboot](https://spring.io/) - Springboot is a framework for developed microservices


## Autors ✒️

* **Tabata Mackenzie** - *Backend Developer* - [tmackenzie](#tmackenzie@gmail.com)