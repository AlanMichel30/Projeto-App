#FROM ubuntu:latest
#LABEL authors="Luana Roberta"

#ENTRYPOINT ["top", "-b"]

# Use a imagem oficial do OpenJDK
FROM openjdk:17-jdk-alpine

# Crie um diretório para o aplicativo
WORKDIR /app

# Copie o arquivo .jar gerado pelo Maven ou Gradle para o contêiner
COPY target/seu-arquivo.jar app.jar

# Exponha a porta que seu aplicativo usa
EXPOSE 8080

# Comando para executar o aplicativo Java
ENTRYPOINT ["java", "-jar", "app.jar"]
