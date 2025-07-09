Feature: Comprar un producto como usuario registrado en Saucedemo

  # TC001 - Seleccionar un producto valido
  Scenario: Seleccionar un producto valido
    Given el usuario inicia sesion en Saucedemo con credenciales validas
    When navega al catalogo de productos
    And selecciona un producto disponible
    Then el sistema muestra el detalle del producto correctamente


