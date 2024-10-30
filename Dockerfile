FROM eclipse-temurin:21
WORKDIR /app
COPY target/questionpro-assessment-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","-noverify","questionpro-assessment-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080