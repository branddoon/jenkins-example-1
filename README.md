# Api in springboot with Jenkins configuration set up

Demo project for a REST API built with Spring Boot, integrated with a Jenkins CI/CD pipeline.

## Description

A minimal Spring Boot application that exposes a REST endpoint, used as a base to demonstrate how to configure a Jenkins pipeline with checkout, build, dependency installation, and test execution stages.

## Tech Stack

- **Java 17**
- **Spring Boot 4.0.3**
- **Maven**
- **Jenkins** (CI/CD)

## Project Structure

```
jenkins-example/
├── src/
│   ├── main/
│   │   ├── java/com/jenkins/example/jenkins_example/
│   │   │   ├── JenkinsExampleApplication.java   # Entry point
│   │   │   └── controller/
│   │   │       └── PrintController.java          # REST controller
│   │   └── resources/
│   │       └── application.properties            # Configuration
│   └── test/
│       └── java/com/jenkins/example/jenkins_example/
│           ├── JenkinsExampleApplicationTests.java
│           └── PrintControllerTest.java
├── Jenkinsfile                                   # Jenkins pipeline
└── pom.xml
```

## API

| Method | Endpoint   | Description    | Response                      |
|--------|------------|----------------|-------------------------------|
| POST   | /api/print | Test endpoint  | `"Printed 200!"` with HTTP 200 |

The application runs on port **8081** by default.

### Example

```bash
curl -X POST http://localhost:8081/api/print
```

## Running Locally

### Prerequisites

- Java 17+
- Maven 3.x

### Build and run

```bash
# Build
./mvnw clean install

# Run
./mvnw spring-boot:run
```

Or run the JAR directly:

```bash
java -jar target/jenkins-example-0.0.1-SNAPSHOT.jar
```

### Run tests

```bash
./mvnw test
```

## Jenkins Pipeline

The `Jenkinsfile` defines a pipeline with three stages:

1. **Checkout Code** — Clones or updates the repository from the `main` branch.
2. **Install Dependencies** — Runs `mvn install` to compile and package the application.
3. **Run Tests** — Runs `mvn test` (controlled by the `RUN_TESTS` environment variable).

### Pipeline Environment Variables

| Variable      | Default Value                                           | Description                        |
|---------------|---------------------------------------------------------|------------------------------------|
| `REPO_URL`    | `https://github.com/branddoon/jenkins-example-1.git`   | Repository URL                     |
| `REPO_DIR`    | `${WORKSPACE}/jenkins-example`                          | Working directory                  |
| `BRANCH_NAME` | `main`                                                  | Branch to deploy                   |
| `RUN_TESTS`   | `true`                                                  | Enables or disables test execution |

### Setting Up in Jenkins

1. Create a new **Pipeline** job in Jenkins.
2. In the pipeline configuration, select **Pipeline script from SCM**.
3. Point it to the repository and the `main` branch.
4. Jenkins will automatically detect the `Jenkinsfile`.
