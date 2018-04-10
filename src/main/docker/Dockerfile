#Establece la imagen base
FROM openjdk:8-jdk-alpine

#Expone el puerto donde va a atender el contenedor
EXPOSE 8000

COPY maven/*.jar app.jar

#Establece el comando a ejecutarse apenas el container este iniciado.
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]