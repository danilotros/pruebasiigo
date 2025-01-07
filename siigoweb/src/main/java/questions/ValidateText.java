package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static ui.SiigoPage.TXT_DASHBOARD;

public class ValidateText implements Question<Boolean> {
    public static ValidateText dashboard(){
        return new ValidateText();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return TXT_DASHBOARD.isVisibleFor(actor);
    }
}
