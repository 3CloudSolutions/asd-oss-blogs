FROM openjdk:17-alpine

WORKDIR /app

RUN apk update
RUN apk add zip

COPY ./target/appinsightinprocessagent.zip /app

RUN unzip appinsightinprocessagent.zip

RUN rm appinsightinprocessagent.zip

CMD ["java", "-javaagent:./resources/applicationinsights-agent-3.4.1.jar", "-jar", "app.jar"]