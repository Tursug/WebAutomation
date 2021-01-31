package com.gittigidiyor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    private static String homePage = "https://www.gittigidiyor.com/";

    // HOVER THIS
    @FindBy(xpath = "/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[1]/div[2]")
    private WebElement btnSignIn;

    //CLICK THIS
    @FindBy(xpath = "//A[@data-cy='header-login-button']")
    private WebElement btnClick;

    // CONSTRUCTOR
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // GO TO THE LOGIN PAGE
    public void getLoginPage(){

        Actions action = new Actions(driver);
        action.moveToElement(btnSignIn).perform();
        wait.until(elementClickable(btnClick));
        btnClick.click();

    }

    // RETURN HOME URL
    public String getHomePage(){
        return homePage;
    }
}
