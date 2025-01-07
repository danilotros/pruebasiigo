package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static ui.SiigoPage.*;

public class ValidateValueText implements Question<Boolean> {
    private String text;
    private Target target;

    public ValidateValueText(String text, Target target) {
        this.text=text;
        this.target = target;
    }

    public static ValidateValueText clientForm(String text){
        return new ValidateValueText(text,TEXT_CLIENT);
    }
    public static ValidateValueText errorLabel(String text){
        return new ValidateValueText(text,ERROR_LABEL);
    } public static ValidateValueText nameLabel(String text){
        return new ValidateValueText(text,NAME_LABEL);
    } public static ValidateValueText lastNameLabel(String text){
        return new ValidateValueText(text,LASTNAME_LABEL);
    } public static ValidateValueText identificationLabel(String text){
        return new ValidateValueText(text,IDENTIFICATION_LABEL);
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).getText().contains(text);

    }
}
