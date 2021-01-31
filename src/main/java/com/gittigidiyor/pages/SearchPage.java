package com.gittigidiyor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;


public class SearchPage extends BasePage{

    // SEARCH INPUT
    @FindBy(xpath = "//INPUT[@type='text']")
    private WebElement searchData;

    // SEARCH BUTTON
    @FindBy(xpath = "//BUTTON[@data-cy='search-find-button']")
    private WebElement searchBtn;

    // PRICE ELEMENT
    @FindBy(xpath = "//SPAN[@id='sp-price-highPrice']")
    private WebElement price1;

    // CONSTRUCTOR
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // FILL THE SEARCH BOX
    public void enterData(String data) {
        this.searchData.clear();
        this.searchData.sendKeys(data);
    }

    // CLICK THE SEARCH BUTTON
    public void submit() {
        searchBtn.click();
    }
    Random random = new Random();
    final int a = random.nextInt(8) + 3;
    final String s = String.valueOf(a);

    // CLICK ITEM IN THE SEARCH PAGE
    public void addToBox(){

        WebElement ele = driver.findElement(By.xpath("(//DIV[@class='gg-w-24 gg-d-24 gg-t-24 gg-m-24 product-title-info'])["+returnRandom()+"]"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
    }

    // GO TO THE SECOND PAGE
    public void secondPage(){
        WebElement ele = driver.findElement(By.xpath("//A[@href='/arama/?k=bilgisayar&sf=2'][text()='2']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
    }

    // ADD ITEM TO THE BOX
    public void addToBox2(){
        WebElement ele = driver.findElement(By.xpath("//BUTTON[@id='add-to-basket']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
    }

    // ITEM PRICE IN THE SEARCH PAGE
    public String getSearchPrice(){
        return price1.getText();
    }

    // RETURN RANDOM NUMBER
    public String returnRandom(){
        Random random = new Random();
        final int a = random.nextInt(48) + 1;
        return String.valueOf(a);
    }


}
