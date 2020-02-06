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
        stage('--Push docker image--') {
              steps {
                    sh "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PSSWRD}"
                    sh "docker tag bbl-backend-production tigs1995/bbl-backend-production"
                    sh "docker push tigs1995/bbl-backend-production"
                    }
              }
        stage('--Deploy to test environment--') {
              steps {
                    sh "ssh -i /home/jenkins/project.pem ubuntu@ec2-18-130-192-141.eu-west-2.compute.amazonaws.com './script.sh'"
                    }
              }
        stage('--Deploy to production environment--') {
              steps {
                    sh "ssh -i /home/jenkins/project.pem ubuntu@ec2-18-130-254-59.eu-west-2.compute.amazonaws.com './script.sh'"
                    }
              }
    }
}
