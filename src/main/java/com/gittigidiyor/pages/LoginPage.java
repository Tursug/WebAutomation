package com.gittigidiyor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // USERNAME FIELD
    @FindBy(id = "L-UserNameField")
    private WebElement username;

    // PASSWORD FIELD
    @FindBy(id = "L-PasswordField")
    private WebElement password;

    // LOGIN BUTTON
    @FindBy(id = "gg-login-enter")
    private WebElement loginButton;

    // LOGGED USER'S NAME
    @FindBy(xpath = "/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[1]/div[2]/span")
    private WebElement user;

    // CONSTRUCTOR
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // FILL THE LOGIN FORM
    public void fillLoginForm(String email, String password) {
        this.username.clear();
        this.username.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);
    }

    // CLICK THE LOGIN BUTTON
    public void submit() {
        loginButton.click();
    }

    // READ LOGGED USER'S NAME
    public String getUserName(){
        return user.getText();
    }
}
