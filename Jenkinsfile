pipeline {
    agent none
    stages {
        stage('Build JAR') {
            agent {
                docker {
                    image 'maven:3.9.3-eclipse-temurin-17-focal'
                    // args '-u root -v /tmp/m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    app = docker.build('manjunathnp/selenium')
                }
            }
        }

        stage('Push Docker Image'){
            steps{
                script {
                    // registry url is blank for dockerhub
                    docker.withRegistry('', 'dockerhub-creds') {
                        app.push("latest")
                    }
                }
            }
        }

    }
}
/*
pipeline{

    agent any

    stages{

        stage('Build JAR'){
            steps{
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build DOCKER Image'){
            steps{
                sh 'docker build -t=manjunathnp/selenium .'
            }
        }

        stage('Push DOCKER Image'){
            environment{
                // assuming you have stored the credentials with this name
                DOCKER_HUB = credentials('dockerhub-creds')
            }
            steps{
                // There might be a warning.
                sh 'docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}'
                sh 'docker push manjunathnp/selenium'
            }
        }

    }

    post {
        always {
            sh 'docker logout'
        }
    }

} */
