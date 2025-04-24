pipeline {
//     agent { docker { image 'maven:3.9.9-eclipse-temurin-21-alpine' } }
    agent any
    stages {
        stage('build') {
            steps {
                echo 'building the security demo application...'
                bat 'mvn --version'
            }
        }
    }
}