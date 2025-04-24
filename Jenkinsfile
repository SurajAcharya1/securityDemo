pipeline {
//     agent { docker { image 'maven:3.9.9-eclipse-temurin-21-alpine' } }
    agent any
    stages {
        stage('checkDocker') {
            steps {
                echo 'checking docker version...'
                bat 'docker --version'
            }
        }
        stage('build') {
            steps {
                echo 'building the security demo application...'
                bat 'mvn clean package'
            }
        }
        stage('createDockerImage') {
            steps {
                echo 'creating docker image of securityDemo...'
                bat 'docker build -t security-demo-app .'
            }
        }
        stage('runDockerContainer') {
            steps {
                echo 'running docker container...'
                bat 'docker run -d -p 8081:8080 --name security-demo-container security-demo-app'
            }
        }
    }
}