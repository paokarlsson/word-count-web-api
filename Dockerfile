FROM maven:3-openjdk-17-slim
COPY ./pom.xml ./pom.xml
COPY ./src/ ./src
EXPOSE 5000
RUN mvn package
CMD ["java","-cp","./target/TextAnalysis-1.0-SNAPSHOT.jar","com.textanalysis.Main"]
