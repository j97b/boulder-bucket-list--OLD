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
                    sh "docker build -t bbl-backend-production ."
                    }
            }
        stage('--Deploy--') {
              steps {
                    sh "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PSSWRD}"
                    sh "docker tag bbl-backend-production tigs1995/bbl-backend-production"
                    sh "docker push tigs1995/bbl-backend-production"
                    }
              }
    }
}
