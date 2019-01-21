FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/i9yang/styleshare.git

FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=0 /app/styleshare /app
RUN mvn package -DskipTests=true

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=1 /app/target/test-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java","-jar","test-0.0.1-SNAPSHOT.jar"]
