package org.siigo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/usercrud.feature",
        glue = "org.siigo.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = ""
)
public class RunnerPrueba {
}
