package starter.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class RemoveOneCourse implements Task {

    private static final Target MENU_ICON =
            Target.the("icono de menú")
                    .locatedBy("//*[@id='menu-icon']");

    private static final Target CART_LINK =
            Target.the("enlace de carrito")
                    .locatedBy("//*[@id='wpmenucartli']/a");

    private static final Target REMOVE_ICON =
            Target.the("icono para eliminar curso")
                    .locatedBy("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[1]/a");

    @Step("{0} elimina un curso del carrito")
    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();

        // 1) Clic en el menú para desplegar la opción del carrito
        WebElement menu = MENU_ICON.resolveFor(actor);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", menu);
        actor.attemptsTo(
                WaitUntil.the(MENU_ICON, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(MENU_ICON)
        );

        // breve espera para despliegue
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}

        // 2) Abrir carrito
        WebElement cart = CART_LINK.resolveFor(actor);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", cart);
        actor.attemptsTo(
                WaitUntil.the(CART_LINK, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(CART_LINK)
        );

        // 3) Esperar a que el botón de eliminar esté clicable
        actor.attemptsTo(
                WaitUntil.the(REMOVE_ICON, isClickable()).forNoMoreThan(10).seconds()
        );

        // 4) Clic en “eliminar”
        WebElement remove = REMOVE_ICON.resolveFor(actor);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", remove);
        actor.attemptsTo(
                Click.on(REMOVE_ICON)
        );

        // 5) Dar tiempo al refresco de la tabla
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
    }

    public static RemoveOneCourse now() {
        return new RemoveOneCourse();
    }
}
