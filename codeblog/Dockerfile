FROM openjdk:11-jdk-slim
VOLUME /tmp
# Quando for iniciado o container ele vai copiar o que esta no caminho para o app.jar dentro do container
ADD codeblog/target/codeblog-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
# Comando para o docker quando ele iniciar
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]