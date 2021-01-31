package com.gittigidiyor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoxPage extends BasePage{

    private static String checkoutUrl = "https://www.gittigidiyor.com/sepetim";

    //CHECKOUT PRICE TAG
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/form/div/div/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[5]/div[1]/div[1]/strong")
    private WebElement Checkoutprice;

    // INCREASE BUTTON
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/form/div/div/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[4]/div/span[2]")
    private WebElement increaseBtn;

    // NUMBER OF ITEMS
    @FindBy(xpath = "//INPUT[@type='text']")
    private WebElement value;

    // DELETE BUTTON
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/form/div/div/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[3]/div/div[2]/div/a[1]/span")
    private WebElement deleteBtn;

    // CONSTRUCTOR
    public BoxPage(WebDriver driver) {
        super(driver);
    }

    // GET THE PRICE IN THE CHECKOUT PAGE
    public String getCheckoutPrice(){
        return Checkoutprice.getText();
    }

    // INCREASE THE NUMBER ITEMS TO TWO
    public void increase() {
        increaseBtn.click();
    }

    // DELETE ITEM
    public void delete(){
        deleteBtn.click();
    }

    // RETURN NUMBER OF ITEMS
    public String value(){
        return value.getAttribute("value");
    }

    // MY BOX PAGE
    public String getCheckoutUrl(){
        return checkoutUrl;
    }
}
