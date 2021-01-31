package com.gittigidiyor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    WebDriverWait wait;

    // CONSTRUCTOR
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 500);
        PageFactory.initElements(driver, this);
    }

    // WAIT PAGE LOAD
    public void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
    }

    // CLICKABLE EXPECTED CONDITION
    public ExpectedCondition<WebElement> elementClickable(WebElement element) {
        ExpectedCondition<WebElement> clickable=ExpectedConditions.elementToBeClickable((element));
        return clickable;
    }
}
