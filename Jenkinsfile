pipeline {
    agent any
    stages {
//         stage('--Docker setup--') {
//                 steps {
//                     sh "usermod -aG docker $USER"
//                     sh "chmod 777 /var/run/docker.sock"
//                     sh "systemctl enable docker"
//                 }
//          }
        stage('--Remove static folder--') {
                steps {
                    sh "rm -rf src/main/resources/static/"
                    }
            }
        stage('--Mvn clean package--') {
                steps {
                    sh "mvn -Dtest=\!selenium* clean package deploy"
                    }
            }
            stage('--Build back-end--') {
                steps {
                    sh "docker build -t bbl-backend-test ."
                    }
            }
        stage('--Deploy--') {
              steps {
                    sh "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PSSWRD}"
                    sh "docker tag bbl-backend-test tigs1995/bbl-backend-test"
                    sh "docker push tigs1995/bbl-backend-test"
                    }
              }
    }
}
