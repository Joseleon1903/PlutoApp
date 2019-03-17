FROM java:8 

# Install maven
RUN apt-get update
RUN apt-get install -y maven

WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml
# Prepare by downloading dependencies
EXPOSE 8085
ENTRYPOINT ["mvn", "spring-boot:run"]