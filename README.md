# Proyecto Spring Boot de Clientes, Cuentas, Movimientos con PostgreSQL y RabbitMQ
Este proyecto es una aplicación de backend desarrollada en Spring Boot, que utiliza PostgreSQL como base de datos y RabbitMQ para mensajería asincrónica. La aplicación está estructurada en microservicios y sigue principios de diseño SOLID y mejores prácticas.

## Arquitectura
### Diagrama de Entidades
![Diagrama de Entidades](/diagramas/reto-entidades.jpeg)

### Diagrama de Microservicios
![Diagrama de Microservicios](/diagramas/reto-microservicios.jpeg)

## Características
Spring Boot: Framework para desarrollar aplicaciones empresariales en Java.

PostgreSQL: Base de datos relacional utilizada para almacenar la información de la aplicación.

RabbitMQ: Broker de mensajería para el manejo de comunicación asincrónica entre servicios.

Microservicios: Arquitectura distribuida con varios microservicios independientes.

## Requisitos Previos
Asegúrate de tener instalado:

Java 21

Maven 3.8+

Docker y Docker Compose (opcional, para despliegue y orquestación)

PostgreSQL (si no usas Docker, instala y configura PostgreSQL)

RabbitMQ (si no usas Docker, instala y configura RabbitMQ)

## Configuración del Proyecto
### Clona el repositorio:

git clone https://github.com/solucionesihk/ejercicio-tecnico.git

cd tu-repositorio

### Configura la base de datos:
Si usas Docker, PostgreSQL se configura en docker-compose.yml. Si usas una instalación local, asegúrate de crear la base de datos y ajustar las credenciales en application.yml.

### Configura RabbitMQ:
Similar a PostgreSQL, RabbitMQ también puede configurarse en docker-compose.yml. Para una instalación local, asegúrate de ajustar las credenciales en application.yml.

### Configura las propiedades de la aplicación:
Modifica el archivo src/main/resources/application.yml con tus configuraciones de base de datos y RabbitMQ:

```yaml
microservice:
  name: '@project.artifactId@'
  version: '@project.version@'
spring:
  threads:
    virtual:
      enabled: true
  application.name: ${microservice.name}
  datasource:
    url: jdbc:postgresql://localhost:5432/base_datos
    username: usuario
    password: password
    hikari:
      connection-timeout: 20000
      auto-commit: false
      minimum-idle: 1
      max-lifetime: 120000
      maximum-pool-size: 10
      idle-timeout: 3000
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
  amqp:
    deserialization:
      trust:
        all: true
```

## Ejecución de los microservicios
### Con Docker Compose
Para ejecutar el proyecto con Docker Compose (PostgreSQL y RabbitMQ se iniciarán automáticamente):

#### Microservicio account
En una terminal cmd/linux:

cd account

mvn clean install

#### Microservicio client
En una terminal cmd/linux:

cd client

mvn clean install

#### Ejecucion de contenedores, después de haber generado los jars correspondientes
En una terminal cmd/linux (Estando en la raíz del proyecto):

docker-compose up

### Manualmente
Inicia PostgreSQL y RabbitMQ si no están en contenedores.

Ejecuta la aplicación de account y client:

mvn spring-boot:run

### Endpoints API

![Colección Postman](/postman/EjercicioTecnico-HerbertTalledo.postman_collection.json)

Algunos ejemplos de endpoints en esta aplicación:

Clientes:

POST /clientes Creación de cliente

GET /clientes Obtención de cliente por id

PUT /clientes Actualización de cliente por id

Cuentas:

POST /cuentas Creación de cuenta

GET /cuentas Obtención de cuenta por numero

PUT /cuentas Actualización de cuenta por numero

Reportes:

GET /reportes Movimientos de cliente en rango fechas

### Ejemplo de Integración con RabbitMQ
Para la comunicación asincrónica entre servicios, RabbitMQ envía y recibe mensajes.

Publicador: AccountPublisher.java (envía mensajes a una cola).

Consumidor: ClientConsumer.java (escucha y procesa mensajes de una cola).

### Pruebas
Para ejecutar pruebas unitarias y de integración:

mvn test

## Despliegue
Para desplegar la aplicación en un servidor, asegúrate de configurar las variables de entorno y ejecutar el comando de inicio. También puedes utilizar herramientas de contenedores como Docker para simplificar el despliegue.