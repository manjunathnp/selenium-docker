pipeline{

    agent any

    stages{

        stage('Build JAR'){
            steps{
                sh "mvn clean package -DskipTests"
            }
        }

        stage('Build Docker Image'){
            steps{
                sh "docker build -t=manjunathnp/selenium ."
            }
        }

        stage('Push Docker Image'){
            environment{
                DOCKER_HUB = credentials('dockerhub creds')
            }
            steps{
                sh 'docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}'
                sh "docker push manjunathnp/selenium"
            }
        }

        post{
            always{
                sh "docker logout"
            }
        }

    }

}