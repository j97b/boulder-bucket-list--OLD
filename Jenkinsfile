pipeline {
    agent any
    stages {
	stage('---SSH into test env---') {
	    steps {
		sh "ssh -i "project.pem" ubuntu@ec2-3-8-144-216.eu-west-2.compute.amazonaws.com"
	    }
	}
        //stage('---Clear---') {
            //steps {
                //sh "docker stop event-booking-system"
                //sh "docker rm event-booking-system"
                //sh "docker rmi -f event-booking-system"
            //}
        //}
	stage('--Clone project--') {
            steps {
                sh "git clone -b development https://github.com/j97b/boulder-bucket-list.git"
                }
        }
	stage('--Remove static folder--') {
            steps {
                sh "mv boulder-bucket-list/src/main/resources/static ."
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
        stage('--Containerize back-end--') {
          steps {
                sh "docker run --name bbl-backend-test -d -p 8085:8082 bbl-backend-test"
                }
          }
    }
}
