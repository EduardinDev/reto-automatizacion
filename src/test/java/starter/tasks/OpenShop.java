package starter.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenShop implements Task {

    @Step("Abrir la pagina del shop")

    public static OpenShop page() {
        return new OpenShop();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String baseUrl = System.getProperty("baseUrl", "http://practice.automationtesting.in");
        actor.attemptsTo(Open.url(baseUrl + "/shop/"));
    }
}
