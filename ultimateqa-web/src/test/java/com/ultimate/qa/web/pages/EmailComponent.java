package com.ultimate.qa.web.pages;

import org.openqa.selenium.By;

public class EmailComponent extends BasePage {
    By nameTxt = By.id("et_pb_contact_name_0");
    By emailTxt = By.id("et_pb_contact_email_0");
    By sendBtn = By.name("et_builder_submit_button");
    By successMsg = By.cssSelector(".et-pb-contact-message>p");
    By errorMsg = By.cssSelector("p.et_pb_contact_error_text");

    public EmailComponent() {
        super();
    }

    public EmailComponent enterName(String name) {
        waitUntilClickable(nameTxt);
        scrollToElement(nameTxt);
        waitABit(2);
        driver.findElement(nameTxt).click();
        driver.findElement(nameTxt).sendKeys(name);
        return this;
    }


    public EmailComponent enterEmail(String email) {
        driver.findElement(emailTxt).sendKeys(email);
        return this;
    }

    public void submit() {
        waitABit(1);
        driver.findElement(sendBtn).click();
        if (driver.findElement(successMsg).getText().contains("Make sure you fill")) {
            driver.findElement(emailTxt).click();
            waitABit(1);
            driver.findElement(sendBtn).click();
        }
    }

    public String getMessage() {
        isDisplayed(successMsg);
        return driver.findElement(successMsg).getText();
    }
}
