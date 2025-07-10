@Login
Feature: Login

  # TC00 - Login
  Scenario: Login exitoso
    Given el usuario esta en la pagina de login
    When el usuario ingresa credenciales username "standard_user" y password "secret_sauce"
    Then el usuario deberia ver el texto "Products"
