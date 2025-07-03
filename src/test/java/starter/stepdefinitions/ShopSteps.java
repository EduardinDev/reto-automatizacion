package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import starter.questions.TotalPrice;
import starter.tasks.AddTwoCourses;
import starter.tasks.OpenShop;
import starter.tasks.RemoveOneCourse;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

public class ShopSteps {

    @Managed(driver = "chrome")
    WebDriver driver;

    Actor edu;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-features=VizDisplayCompositor");
        options.addArguments("--start-maximized");

        edu = Actor.named("Eduardo");
        edu.can(BrowseTheWeb.with(driver));

        System.setProperty("baseUrl", "http://practice.automationtesting.in");
    }

    @Given("que el usuario abre la pagina del shop")
    public void que_el_usuario_abre_la_pagina_del_shop() {
        edu.attemptsTo(OpenShop.page());

        // Verificar que la página se cargó correctamente
        try {
            Thread.sleep(3000); // Esperar 3 segundos para que cargue completamente
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @When("agrega dos cursos al carrito")
    public void agrega_dos_cursos_al_carrito() {
        edu.attemptsTo(AddTwoCourses.now());
    }

    @When("elimina uno de ellos")
    public void elimina_uno_de_ellos() {
        edu.attemptsTo(RemoveOneCourse.now());
    }

    @Then("el total debe ser menor a {double}")
    public void el_total_debe_ser_menor_a(double limite) {
        then(edu).should(
                seeThat("precio total", TotalPrice.value(), price -> price < limite)
        );
    }
}