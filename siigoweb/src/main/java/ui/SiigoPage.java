package ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://qastaging.siigo.com/#/login")
public class SiigoPage extends PageObject{
public static final Target INPUT_USERNAME= Target.the("input for username").located(id("username"));
public static final Target INPUT_PASSWORD= Target.the("input for user password").located(id("current-password"));
public static final Target BTN_LOGIN= Target.the("login button").located(id("login-submit"));
public static final Target TXT_DASHBOARD= Target.the("text dashboard").located(xpath("(//div[contains(text(),'Inicio')])[1]"));
public static final Target BTN_CREATE= Target.the("button create").located(xpath("//siigo-button-atom[@text='Crear']"));
public static final Target LINK_CLIENT= Target.the("link client").located(xpath("//a[text()='Clientes']"));
public static final Target TEXT_CLIENT= Target.the("link client").located(xpath("//h2[text()='Crear un tercero']"));
}
