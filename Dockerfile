FROM openjdk:8-jdk
COPY target/gitops-demo-*.jar /app.jar
CMD ["java", "-jar", "/app.jar"]