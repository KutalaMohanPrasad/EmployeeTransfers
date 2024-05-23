From openjdk:latest
ADD target/employeeTransfers-0.0.1-SNAPSHOT.war employeeTransfers-0.0.1.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "employeeTransfers-0.0.1.war"]