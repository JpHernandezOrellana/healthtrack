# 🩺 HealthTrack

**HealthTrack** es una plataforma Java para el monitoreo de peso corporal, desarrollada como parte de la **Evaluación del Módulo 4 del curso Fundamentos de DevOps**.

El objetivo principal fue **automatizar la validación del código mediante pruebas y análisis de calidad**, integrando un pipeline de CI/CD completo con herramientas modernas del ecosistema DevOps.

---

## ⚠️ Problema Detectado

El sistema contenía un error crítico en el método `actualizarPeso()`:

```java this.peso -= 1;```
Esto provocaba que, al actualizar su peso, el usuario perdiera automáticamente 1 kg, sin importar el valor ingresado. Este fallo generaba:

Datos incorrectos en el historial.

Pérdida de confianza en la plataforma.

Riesgo sanitario si se usa con fines médicos.

**Solución Implementada**

✅ Se corrigió la lógica y se desarrolló un proceso de validación continuo mediante:

✅ Pruebas unitarias con JUnit

✅ Pruebas funcionales sin interfaz gráfica usando Spark Java

✅ Pruebas de rendimiento con Apache JMeter

✅ Análisis estático de código con SonarQube

✅ Pipeline CI/CD automatizado en Jenkins

🧪 Estructura de Pruebas
🔹 Pruebas Unitarias (JUnit)
Ubicación: src/test/java/...

Validan el método actualizarPeso() para asegurar que guarda correctamente el valor ingresado.

🔹 Pruebas Funcionales (Spark Java)
Simulan el flujo completo del usuario: registro, actualización y consulta de peso.

Se ejecutan sobre endpoints mockeados con Spark Java (sin UI).

🔹 Pruebas de Rendimiento (JMeter)
Archivo: healthtrack_test.jmx

Simula múltiples usuarios actualizando su peso en paralelo.

Evalúa tiempo de respuesta y estabilidad bajo carga.

⚙️ CI/CD Pipeline (Jenkins)

El archivo Jenkinsfile contiene las siguientes etapas automatizadas:

- Preparación del entorno

- Clonación del repositorio desde GitHub

- Compilación del proyecto con Maven

- Ejecución de pruebas unitarias

- Pruebas de rendimiento con JMeter

- Análisis de calidad de código con SonarQube

- Reporte del estado del pipeline

📁 Archivos Relevantes
Archivo / Carpeta	Descripción
src/	Código fuente de la aplicación
pom.xml	Configuración de dependencias y build con Maven
Jenkinsfile	Definición del pipeline CI/CD en Jenkins
sonar-project.properties	Configuración para análisis con SonarQube
healthtrack_test.jmx	Script JMeter para pruebas de carga

🚀 Cómo Ejecutar

Requisitos:

- Java 21

- Maven 3

- Jenkins instalado y configurado

- SonarQube activo (local o remoto)

- Apache JMeter

Ejecutar pruebas localmente:

- bash
- Copiar
- Editar
- mvn clean test
- Ejecutar el pipeline automáticamente:
- Realiza un git push al repositorio. Jenkins detectará el cambio y ejecutará todas las etapas del pipeline.

🔐 Seguridad

El acceso a SonarQube desde Jenkins se realiza mediante tokens protegidos con withCredentials, evitando exponer información sensible directamente en el Jenkinsfile.

📌 Resultado Final

El proyecto ahora cuenta con un proceso completo de validación continua que:

- Detecta errores críticos antes de llegar a producción.

- Asegura la calidad y estabilidad del sistema.

- Mejora la trazabilidad y confiabilidad de los cambios.

- HealthTrack está listo para escalar como una solución moderna, confiable y automatizada.





