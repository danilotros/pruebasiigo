package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static ui.SiigoPage.TEXT_CLIENT;

public class ValidateValueText implements Question<Boolean> {
    private String text;

    public ValidateValueText(String text) {
        this.text=text;
    }

    public static ValidateValueText clientForm(String text){
        return new ValidateValueText(text);
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return TEXT_CLIENT.resolveFor(actor).getText().contains(text);

    }
}
