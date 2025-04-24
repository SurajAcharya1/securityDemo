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
                bat 'mvn --version'
            }
        }
    }
}