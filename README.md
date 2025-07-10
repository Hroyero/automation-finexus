# 🚀 Reto Técnico – QA Automatizador Finexus

Este repositorio contiene la solución automatizada para la **Historia de Usuario HU001** del reto técnico **Finexus**, usando **Selenium**, **Java** y **Cucumber**, estructurado con **Page Object Model (POM)** y buenas prácticas de QA Automation.

---

## 📌 **Historia de Usuario**

> **HU001**  
> *Como usuario registrado, quiero poder seleccionar un producto, agregarlo al carrito y completar el proceso de compra mediante un formulario con mis datos, para recibir el producto en mi domicilio.*

---

## ✅ **Casos de Prueba Automatizados**

1. **Seleccionar un producto válido**
2. **Agregar producto al carrito**
3. **Completar formulario de compra con datos válidos**
4. **Intento de compra con campos vacíos**
5. **Validación de resumen final antes del pago**

Los scripts validan:
- Nombre del producto.
- Precio del producto.
- Mensajes de confirmación y error.
- Resumen final con datos correctos.

---

## 🧩 **Tecnologías Usadas**

- **Java 17**
- **Selenium WebDriver**
- **Cucumber BDD**
- **JUnit**
- **Gradle**
- **Allure Report**
- **Xray (Simulado)** para diseño de pruebas funcionales.

---
## 📂 **Estructura del Proyecto**

├── src
│ ├── main/java/com/automation/pages # Clases Page Object
│ ├── test/java/com/automation/stepdefinitions # Steps Cucumber
│ └── test/resources/features # Features Gherkin
├── build.gradle # Dependencias
├── README.md # Este archivo

## ⚙️ **Ejecutar las Pruebas**

1️⃣ Clona el repositorio:
```bash
git clone https://github.com/Hroyero/automation-finexus.git

2️⃣ Ejecuta las pruebas:
gradlew clean test

3️⃣ Genera el reporte Allure:
gradlew allureReport

4️⃣ Abre el reporte:
gradlew allureServe

🚀 Buenas Prácticas Implementadas

✔️ Patrón Page Object Model (POM).
✔️ Separación de lógica: Pages, Steps y Features.
✔️ Hooks para abrir/cerrar navegador y adjuntar evidencias.
✔️ Esperas explícitas (WebDriverWait) para sincronización robusta.
✔️ Validaciones claras con assertEquals y assertTrue


💡 Lecciones Aprendidas
Uso efectivo de POM para mantener el código escalable.
Validación robusta del flujo end-to-end de compra.
Buen manejo de waits y condiciones dinámicas.
Organización del proyecto para fácil mantenimiento.

🟢 Estado del Proyecto
✔️ Funcional y probado
✔️ Listo para revisión
✔️ Estructura clara para escalar más pruebas o incluir APIs
