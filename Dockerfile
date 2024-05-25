From openjdk:latest
ADD target/employee-transfers-0.0.1.war employee-transfers-0.0.1.war
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "employee-transfers-0.0.1.war"]