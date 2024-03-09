package com.ultimate.qa.web.pages;

import com.ultimate.qa.web.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public final WebDriver driver;
    private final WebDriverWait defaultWait;


    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.defaultWait = new WebDriverWait(driver, Duration.ofSeconds(120));
    }

    public boolean isDisplayed(By element) {
        try {
            defaultWait.until(ExpectedConditions.visibilityOfElementLocated(element));
            defaultWait.until(ExpectedConditions.presenceOfElementLocated(element));
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

    public void scrollToElement(By by){
        new Actions(driver)
                .scrollToElement(driver.findElement(by))
                .perform();
    }

    public boolean waitUntilClickable(By by) {
        try {
            defaultWait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

    public void waitABit(long i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException ignore) {
        }
    }
}
