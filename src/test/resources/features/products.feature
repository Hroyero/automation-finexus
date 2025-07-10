@Products
Feature: Comprar un producto como usuario registrado en Saucedemo
@TC001
  # TC001 - Seleccionar un producto valido
  Scenario: Seleccionar un producto valido
    Given el usuario inicia sesion en Saucedemo con credenciales validas
    When navega al catalogo de productos y ve el titulo "Swag Labs"
    And selecciona un producto disponible
    Then el sistema muestra el detalle del producto correctamente

@TC002
 # TC002 - Agregar producto al carrito
  Scenario: Agregar producto al carrito
    Given el usuario esta en la pagina de detalle de un producto valido
    When hace clic en el boton Add to cart
    And navega al carrito de compras
    Then el carrito muestra el nombre del producto y precio correcto
