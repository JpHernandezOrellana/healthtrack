pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
        git 'Git'
    }

    stages {
        stage('Clonar código') {
            steps {
                git 'https://github.com/JpHernandezOrellana/healthtrack.git'
            }
        }

        stage('Compilar') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Ejecutar pruebas') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Final') {
            steps {
                echo '✅ Compilación y pruebas finalizadas correctamente.'
            }
        }
    }

    post {
        failure {
            echo '❌ Falló el pipeline.'
        }
    }
}
