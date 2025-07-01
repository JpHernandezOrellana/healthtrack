pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }

    stages {
        stage('Preparar entorno') {
            steps {
                cleanWs()
            }
        }

        stage('Clonar código') {
            steps {
                git branch: 'main', url: 'https://github.com/JpHernandezOrellana/healthtrack.git'
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

        stage('Pruebas de rendimiento') {
            steps {
                sh '~/apache-jmeter-5.6.3/bin/jmeter -n -t pruebas/prueba_basica.jmx -l resultados/resultados.jtl'
            }
        }

        stage('Final') {
            steps {
                echo '✅ Compilación y pruebas finalizadas correctamente.'
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline completado exitosamente.'
        }
        failure {
            echo '❌ Falló el pipeline.'
        }
        always {
            echo '📦 Pipeline finalizado. Revisar logs si hubo errores.'
        }
    }
}
