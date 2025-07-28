@Login
Feature: Login

  Background: Navegación inicial
    Given el usuario esta en la pagina de login

  # TC001 - Login exitoso
  @positive
  Scenario: [LOGIN_001] Usuario valido accede correctamente
    When el usuario ingresa credenciales username "standard_user" y password "secret_sauce"
    Then el usuario deberia ver el texto "Products"

  # TC002 - Usuario vacío
  @negative
  Scenario: [LOGIN_002] Usuario vacio genera error
    When el usuario ingresa credenciales username "" y password "secret_sauce"
    Then Deberian ver el mensaje de error "Epic sadface: Username is required"

  # TC003 - Contraseña vacía
  @negative
  Scenario: [LOGIN_003] Contrasena vacia genera error
    When el usuario ingresa credenciales username "standard_user" y password ""
    Then Deberian ver el mensaje de error "Epic sadface: Password is required"

  # TC004 - Usuario inválido
  @negative
  Scenario: [LOGIN_004] Usuario invalido genera error
    When el usuario ingresa credenciales username "fake_user" y password "secret_sauce"
    Then Deberian ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"

  # TC005 - Contraseña inválida
  @negative
  Scenario: [LOGIN_005] Contrasena incorrecta genera error
    When el usuario ingresa credenciales username "standard_user" y password "wrongpass"
    Then Deberian ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"
