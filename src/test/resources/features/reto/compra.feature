
Feature: Carrito de compras en Automation Practice

  Scenario: Agregar y eliminar productos del carrito
    Given que el usuario abre la pagina del shop
    When agrega dos cursos al carrito
    And elimina uno de ellos
    Then el total debe ser menor a 400
