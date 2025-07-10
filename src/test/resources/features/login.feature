@Login
Feature: Login

  # TC00 - Login
  Scenario: Login exitoso
    Given el usuario esta en la pagina de login
    When el usuario ingresa credenciales username "standard_user" y password "secret_sauce"
    Then el usuario deberia ver el texto "Products"


  Scenario: Login fallido usuario vacio
    Given el usuario esta en la pagina de login
    When el usuario ingresa credenciales username "" y password "secret_sauce"
    Then Deberian ver el mensaje de error "Epic sadface: Username is required"

  Scenario: Login fallido contrasena vacio
    Given el usuario esta en la pagina de login
    When el usuario ingresa credenciales username "standard_user" y password ""
    Then Deberian ver el mensaje de error "Epic sadface: Password is required"

  Scenario: Login fallido usuario invalida
    Given el usuario esta en la pagina de login
    When el usuario ingresa credenciales username "fake_user" y password "secret_sauce"
    Then Deberian ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login fallido contrasena invalida
    Given el usuario esta en la pagina de login
    When el usuario ingresa credenciales username "standard_user" y password "wrongpass"
    Then Deberian ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"