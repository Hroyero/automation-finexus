@Checkout
Feature: Pagar un producto como usuario registrado en Saucedemo

  # TC003 - Completar formulario de compra con datos válidos
  Scenario: Completar formulario de compra con datos validos
    Given el usuario tiene un producto en el carrito de compras
    When navega al checkout
    And completa el formulario de checkout con "John", "Doe", "12345"
    Then El usuario debería ver un mensaje de confirmacion "Thank you for your order!"

  # TC004 - Intento de compra con campos vacíos
  Scenario: Intentar compra con campos vacios
    Given el usuario tiene un producto en el carrito de compras
    When navega al checkout
    And completa el formulario de checkout con "", "Doe", "12345"
    And hace clic en continuar
    Then El mensaje de error de pago deberia ser "Error: First Name is required"

  # TC005 - Validación del resumen final antes del pago
  Scenario: Validar resumen final antes del pago
    Given el usuario completa el formulario de checkout con datos validos
    When revisa la pagina de resumen de compra
    Then el resumen muestra productos seleccionados, precio total y datos del cliente correctamente
