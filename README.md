HealthTrack
HealthTrack es una plataforma de monitoreo de peso desarrollada en Java. Este proyecto fue realizado como parte de la Evaluación del Módulo 4 del curso Fundamentos de DevOps.

El enfoque principal fue diseñar e implementar un pipeline de CI/CD que garantice la calidad del código mediante pruebas automatizadas y análisis estático.

Problema Detectado
El sistema originalmente contenía un bug crítico en la lógica de actualización del peso:

this.peso -= 1;

Cada vez que un usuario actualizaba su peso, el sistema restaba 1 kg en lugar de guardar el nuevo valor. Esto generaba datos incorrectos y pérdida de confianza en la plataforma.

Solución Implementada
Se corrigió la lógica y se implementaron pruebas automatizadas que detectan errores en cada etapa del desarrollo:

Pruebas unitarias con JUnit

Pruebas funcionales sin UI con Spark Java (mock de endpoints)

Pruebas de rendimiento con Apache JMeter

Análisis estático con SonarQube

Pipeline de CI/CD automatizado en Jenkins

Estructura de Pruebas
Pruebas Unitarias
Ubicación: src/test/java/...
Ejecutan casos específicos del método actualizarPeso() para asegurar su correcto funcionamiento.

Pruebas Funcionales
Simulan el flujo de usuario (registro, actualización y consulta de peso) mediante endpoints mockeados con Spark Java.

Pruebas de Rendimiento
El script healthtrack_test.jmx de Apache JMeter simula múltiples usuarios accediendo al sistema en paralelo.

CI/CD Pipeline (Jenkins)
El archivo Jenkinsfile contiene todas las etapas necesarias para la automatización del flujo de desarrollo:

Preparación del entorno

Clonación del repositorio

Compilación del proyecto con Maven

Ejecución de pruebas unitarias

Lanzamiento de pruebas de rendimiento (JMeter)

Análisis de calidad con SonarQube

Resultado final del pipeline

Archivos Importantes
src/ – Código fuente del proyecto

pom.xml – Archivo de configuración de Maven

Jenkinsfile – Definición del pipeline CI/CD

sonar-project.properties – Configuración de análisis estático con SonarQube

healthtrack_test.jmx – Script de pruebas de rendimiento para JMeter

Cómo Ejecutar
Requisitos previos

Java 21

Maven 3


