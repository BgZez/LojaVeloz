FROM ubuntu:latest
LABEL authors="breno"

# Usa a imagem que tem o Maven e o Java instalados
FROM maven:3.9-eclipse-temurin-21-alpine AS builder

# 1. Dizemos para o Docker: "Crie a pasta /app e entre nela"
WORKDIR /app

# 2. Copiamos o arquivo de configuração de dependências do seu PC para o contêiner
COPY pom.xml .

# 3. Copiamos a pasta com o código fonte e rodamos o comando do Maven para compilar
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

# 4. Define a pasta de trabalho
WORKDIR /app

# 5. Cria usuário e grupo de segurança do Alpine Linux
RUN addgroup -S spring && adduser -S spring -G spring

# 6. Troca para o usuário restrito
USER spring

# 7. Copia APENAS o .jar gerado no primeiro estágio
COPY --from=builder /app/target/*.jar app.jar

# 8. Documenta a porta e inicia a aplicação
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]