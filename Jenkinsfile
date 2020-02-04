pipeline { environment {
	registry = "tigs1995/bbl-backend-test"
	registryCredential = 'dockerhub'
}
    agent any
    stages {
        stage('---Clear---') {
            steps {
//                sh "docker stop bbl-backend-test"
//                sh "docker rm bbl-backend-test"
//                sh "docker rmi -f bbl-backend-test"
		sh "cd"
		sh "rm -rf boulder-bucket-list"
          }
       }
	stage('--Clone project--') {
            steps {
                sh "git clone -b development https://github.com/j97b/boulder-bucket-list.git"
                }
        }
	stage('--Remove static folder--') {
            steps {
                sh "rm -rf boulder-bucket-list/src/main/resources/static"
		sh "cd boulder-bucket-list"
                }
        }
	stage('--Mvn clean package--') {
            steps {
                sh "mvn clean package"
                }
        }
        stage('--Build back-end--') {
            steps {
                sh "docker build -t bbl-backend-test ."
                }
        }
	stage('--Deploy--') {
          steps {
                sh "docker tag bbl-backend-test registry"
		sh "docker push registry"
                }
          }
    }
}
