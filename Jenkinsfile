pipeline {
    agent any

    environment {
        REPO_URL = "https://github.com/branddoon/jenkins-example-1.git"
        REPO_DIR = "${WORKSPACE}/jenkins-example"
        BRANCH_NAME = "main"
        RUN_TESTS = "true"
    }

    stages {
        stage('Checkout Code') {
            steps {
                script {
                    echo "Cloning branch: ${BRANCH_NAME} from ${REPO_URL}"
                    sh """
                        if [ -d "${REPO_DIR}" ]; then
                            cd ${REPO_DIR}
                            git checkout ${BRANCH_NAME}
                            git pull origin ${BRANCH_NAME}
                        else
                            git clone --branch ${BRANCH_NAME} ${REPO_URL} ${REPO_DIR}
                        fi
                    """
                }
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    echo "Installing dependencies..."
                    dir("${REPO_DIR}") {
                        sh """
                        pwd
                        mvn install
                        """
                    }
                }
            }
        }

        stage('Run Tests') {
            when {
                expression { return env.RUN_TESTS == "true" }
            }
            steps {
                script {
                    echo "Running tests..."
                    dir("${REPO_DIR}") {
                        sh """
                        mvn test
                        """
                    }
                }
            }
        }

        stage('Run Application') {
            steps {
                script {
                    echo "Starting Spring boot application..."
                    dir("${REPO_DIR}") {
                        sh """
                        pwd
                        java -jar target/jenkins-example-0.0.1-SNAPSHOT.jar
                        """
                    }
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline executed successfully!"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}