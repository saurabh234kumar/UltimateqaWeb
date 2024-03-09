package com.ultimate.qa.web.stepDefs;

import com.ultimate.qa.web.pages.LoginPage;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class LoginStepDef {
    private LoginPage loginPage;

    @Given("I launch the application")
    public void i_launch_the_application() {
        loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isDisplayed());
    }
}
