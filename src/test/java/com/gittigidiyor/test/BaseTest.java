package com.gittigidiyor.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void before(){
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void after() throws InterruptedException{
        Thread.sleep(3000);
    }

}
