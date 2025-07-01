pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }

    environment {
        SONAR_SCANNER_HOME = '/home/jp/utilidades/sonar-scanner'
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
                sh '/home/jp/apache-jmeter-5.6.3/bin/jmeter -n -t pruebas/prueba_basica.jmx -l resultados/resultados.jtl'
            }
        }

        stage('Análisis de código con SonarQube') {
            steps {
                withCredentials([string(credentialsId: 'sonarqube-token', variable: 'SONAR_TOKEN')]) {
                    sh '''
                        ${SONAR_SCANNER_HOME}/bin/sonar-scanner \
                        -Dsonar.login=${SONAR_TOKEN}
                    '''
                }
            }
        }

        stage('Final') {
            steps {
                echo '✅ Compilación, pruebas y análisis finalizados correctamente.'
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
// holis
