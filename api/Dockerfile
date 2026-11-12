# ============================================================================
# Dockerfile do TaskForge: a "receita" que o Render usa pra empacotar a API.
# Duas etapas: (1) compila com o Maven, (2) roda so o .jar num Java enxuto.
# ============================================================================

# ---- etapa 1: compilar ----
FROM maven:3.9-eclipse-temurin-26 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -B -q dependency:go-offline
COPY src ./src
RUN mvn -B -q -DskipTests clean package

# ---- etapa 2: rodar ----
FROM eclipse-temurin:26-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# O free tier do Render tem ~512 MB. Esta linha segura a memoria da JVM
# pra ela nao estourar e o servidor matar o processo (erro 137 / OOM).
ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=65 -XX:+UseSerialGC"

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
