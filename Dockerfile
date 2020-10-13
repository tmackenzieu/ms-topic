FROM openjdk:11

WORKDIR /app

COPY ./target/app.jar .
COPY ./docker .

USER root

EXPOSE 8080

ENTRYPOINT ["/app/entrypoint.sh"]
