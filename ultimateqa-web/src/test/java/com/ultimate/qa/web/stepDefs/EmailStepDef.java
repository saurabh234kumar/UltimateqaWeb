package com.ultimate.qa.web.stepDefs;

import com.ultimate.qa.web.pages.EmailComponent;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class EmailStepDef {

    private EmailComponent emailComponent;

    @Then("I enter username as {string} and email address as {string}")
    public void iEnterUsernameAsAndEmailAddressAs(String name, String email) {
        emailComponent = new EmailComponent();

        emailComponent
                .enterName(name)
                .enterEmail(email);

    }

    @When("I submit")
    public void iSubmit() {
        emailComponent.submit();
    }

    @Then("I should see {string}")
    public void iShouldSee(String message) {
        Assert.assertEquals(emailComponent.getMessage(),message);
    }
}
