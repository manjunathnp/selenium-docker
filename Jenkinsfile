/*
    Note:

    Windows users use "bat" instead of "sh"
    For ex: bat 'docker build -t=vinsdocker/selenium .'

    Do not use "vinsdocker" to push. Use your dockerhub account
*/
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

}