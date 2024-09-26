# Pruebas Automatizadas con Selenium y Java
=======================================

Este proyecto es un ejemplo de cómo realizar **pruebas automatizadas** utilizando **Selenium WebDriver** con **Java**. Las pruebas están ubicadas en la carpeta `src/test`, y cada una corresponde a un reto específico basado en requisitos proporcionados.

## Lista de Retos y Pruebas

### Reto #1: Prueba de Login

- **Requisitos**: [Requisitos Reto 1](https://drive.google.com/file/d/1YI98bM5R6yNbC6cOVAuOeKDXg0p6zCkP/view)
- **Página web**: [Test Store](https://teststore.automationtesting.co.uk/index.php)
- **Archivo de test**: `Reto1LoginTest.java`

### Reto Iframe: Manejo de Iframes

- **Requisitos**: [Reto Iframe](https://drive.google.com/file/d/1HRWggulXQ0GvwsjC0cGK9xJuu3NeTr32/view)
- **Página web**: [Automation Testing Iframes](https://automationtesting.co.uk/iframes.html)
- **Archivo de test**: `src/test/RetoIframeTest.java`

### Reto Alert: Manejo de Alertas

- **Requisitos**: [Reto Alert](https://drive.google.com/file/d/1VfZBt82BiVWp39585YN4NW2jRF-fpDH0/view)
- **Página web**: [Automation Testing Popups](https://automationtesting.co.uk/popups.html)
- **Archivo de test**: `RetoIAlertTest.java`

### Reto Tab: Manejo de Pestañas del Navegador

- **Requisitos**: [Reto Tab](https://drive.google.com/file/d/1lYnalF_gNhuNdGp2WkvcAdzCY5jQ0_uH/view)
- **Página web**: [Automation Testing Browser Tabs](https://automationtesting.co.uk/browserTabs.html)
- **Archivo de test**: `RetoTabTest.java`

## Configuración del Proyecto

El proyecto utiliza **Gradle** como administrador de dependencias.

- Estructura del proyecto
    ```
    ├── build.gradle
    ├── src
    │   └── test
    │       ├── java
    │       │   ├── Reto1LoginTest.java
    │       │   ├── RetoIframeTest.java
    │       │   ├── RetoIAlertTest.java
    │       │   └── RetoTabTest.java
    │       └── resources
    └── README.md
    ```
## Ejecución de las pruebas

Ejecutar las Pruebas con Gradle

Navega al directorio del proyecto y ejecuta:

```gradle test```

O si usas el wrapper de Gradle:

```./gradlew test```