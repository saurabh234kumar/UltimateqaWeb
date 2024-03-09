package com.ultimate.qa.web.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By entryContent = By.className("entry-content");

    public LoginPage() {
        super();
    }

    public boolean isDisplayed() {
        return isDisplayed(entryContent);
    }
}
