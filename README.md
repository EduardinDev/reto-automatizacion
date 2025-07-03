
# Proyecto de Automatización con Serenity Screenplay

Esta guía describe los pasos necesarios para configurar y ejecutar el suite de pruebas **RetoTestSuite**.

---

## 1. Prerrequisitos

1. **Google Chrome**
    - Descarga e instala la misma versión de Chrome que usarás para las pruebas.
    - Ejemplo: [Google Chrome 138.0.7204.97](https://www.google.com/chrome/)

2. **ChromeDriver**
    - Descarga la versión de ChromeDriver que corresponda a tu Chrome.
    - Ejemplo: ChromeDriver `138.0.7204.92`
    - Descomprime el ejecutable y apunta en `serenity.properties` a su ruta:
      ```properties
      webdriver.chrome.driver=C:\\Tools\\chromedriver\\chromedriver.exe
      ```

3. **Java 17+**
    - Asegúrate de tener instalado JDK 17 o superior.
    - Comprueba con:
      ```bash
      java -version
      ```

4. **Gradle**
    - Puedes usar el wrapper incluido (`gradlew`/`gradlew.bat`).
    - Si prefieres, instala Gradle globalmente (v7+).




