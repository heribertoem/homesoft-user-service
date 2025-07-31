# Etapa 1: Construcción del proyecto
FROM eclipse-temurin:21-jdk-alpine as builder

# Instala herramientas necesarias para Gradle y certifica SSL
RUN apk add --no-cache bash curl zip unzip ca-certificates

# Establece el directorio de trabajo para la construcción
WORKDIR /app

# Copia los archivos del proyecto al contenedor
COPY . .

# Ejecuta la construcción del proyecto para generar el JAR
RUN ./gradlew clean build --no-daemon

# Etapa 2: Imagen final
FROM eclipse-temurin:21-jdk-alpine

# Instala certificados raíz para conexiones SSL
RUN apk add --no-cache ca-certificates

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado desde la etapa de construcción
COPY --from=builder /app/build/libs/*.jar app.jar

# Expone el puerto configurado en la aplicación (1020)
EXPOSE 1020

# Configura variables de entorno para MongoDB
ENV SPRING_DATA_MONGODB_URI=mongodb+srv://heribertoem19:-6PS234n2nTeLcH@mycluster.ei0r1.mongodb.net/sample_mflix?retryWrites=true&w=majority
ENV SPRING_DATA_MONGODB_DATABASE=sample_mflix

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
