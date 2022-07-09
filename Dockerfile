FROM bellsoft/liberica-openjdk-alpine-musl:17
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]