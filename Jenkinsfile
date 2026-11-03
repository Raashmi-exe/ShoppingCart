pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Retrieving source code from GitHub'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Compiling Java application'
                script {
                    if (isUnix()) {
                        sh 'mvn clean compile'
                    } else {
                        bat 'mvn clean compile'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Running JUnit test cases'
                script {
                    if (isUnix()) {
                        sh 'mvn test'
                    } else {
                        bat 'mvn test'
                    }
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging Java application'
                script {
                    if (isUnix()) {
                        sh 'mvn package -DskipTests'
                    } else {
                        bat 'mvn package -DskipTests'
                    }
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            echo 'BUILD SUCCESSFUL!'
        }
        failure {
            echo 'BUILD FAILED! Check console output.'
        }
    }
}
