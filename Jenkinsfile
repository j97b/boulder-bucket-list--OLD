pipeline {
    agent any
    stages {
        stage('--Remove static folder--') {
                steps {
                    sh "rm -rf src/main/resources/static/"
                    }
            }
        stage('--Mvn clean package--') {
                steps {
                    sh "mvn clean package deploy"
                    }
            }
            stage('--Build back-end--') {
                steps {
                    sh "docker build -t bbl-backend-test ."
                    }
            }
        stage('--Deploy--') {
              steps {
                    sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PSSWRD}"
                    sh "docker tag bbl-backend-test tigs1995/bbl-backend-test"
                    sh "docker push tigs1995/bbl-backend-test"
                    }
              }
    }
}
