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
            steps{
                echo "docker push manjunathnp/selenium"
            }
        }

    }

}