package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class TotalPrice implements Question<Double> {

    private static final Target TOTAL = Target.the("precio total")
            .locatedBy("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span");

    @Step("Obtener el precio total de los cursos")
    @Override
    public Double answeredBy(Actor actor) {
        String text = TOTAL.resolveFor(actor)
                .getText();
        // Eliminamos todo lo que no sea dígito o punto
        String numeric = text.replaceAll("[^\\d.]", "");
        return Double.valueOf(numeric);
    }

    public static TotalPrice value() {
        return new TotalPrice();
    }
}
