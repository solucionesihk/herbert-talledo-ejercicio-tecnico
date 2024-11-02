# Usar una imagen de Java JDK
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo .jar de la aplicación al contenedor
COPY target/client-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/application.yml src/main/resources/application.yml

# Exponer el puerto en el que la aplicación estará disponible
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]