FROM openjdk:16-alpine3.13
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY "build/libs/*.jar" "app.jar"
ENTRYPOINT ["java","-jar","/app.jar"]