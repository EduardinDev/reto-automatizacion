package starter.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddTwoCourses implements Task {

    private static final Target PRODUCT_LIST = Target.the("Product list")
            .locatedBy("//*[@id='content']/ul");

    private static final Target FIRST_ADD_TO_BASKET = Target.the("First add to basket button")
            .locatedBy("(//*[@id='content']/ul/li//a[contains(text(), 'Add to basket') or contains(@class, 'add_to_cart')])[1]");

    private static final Target SECOND_ADD_TO_BASKET = Target.the("Second add to basket button")
            .locatedBy("(//*[@id='content']/ul/li//a[contains(text(), 'Add to basket') or contains(@class, 'add_to_cart')])[2]");

    @Step("Agregar dos cursos al carrito")
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Esperar a que la lista de productos cargue
        actor.attemptsTo(
                WaitUntil.the(PRODUCT_LIST, isVisible()).forNoMoreThan(10).seconds()
        );

        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();

        // Primer curso
        WebElement firstBtn = FIRST_ADD_TO_BASKET.resolveFor(actor);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", firstBtn);
        actor.attemptsTo(
                WaitUntil.the(FIRST_ADD_TO_BASKET, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(FIRST_ADD_TO_BASKET)
        );

        // Pequeña pausa
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        // Segundo curso
        WebElement secondBtn = SECOND_ADD_TO_BASKET.resolveFor(actor);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", secondBtn);
        actor.attemptsTo(
                WaitUntil.the(SECOND_ADD_TO_BASKET, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(SECOND_ADD_TO_BASKET)
        );
    }

    public static AddTwoCourses now() {
        return new AddTwoCourses();
    }
}
