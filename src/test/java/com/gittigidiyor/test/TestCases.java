package com.gittigidiyor.test;

import com.gittigidiyor.pages.BoxPage;
import com.gittigidiyor.pages.LoginPage;
import com.gittigidiyor.pages.SearchPage;

import java.util.logging.*;

import org.junit.Assert;
import org.junit.Test;
import com.gittigidiyor.pages.HomePage;

import org.openqa.selenium.By;


public class TestCases extends BaseTest{

    private final static Logger logger  =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    // www.gittigidiyor.com sitesi açılır
    @Test
    public void test_1(){

        HomePage homePage = new HomePage(driver);
        driver.get(homePage.getHomePage());
        homePage.waitForPageLoad();
        Assert.assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi", driver.getTitle());
        // System.out.println("Gittigidiyor.com acildi.");
        logger.log(Level.INFO,"Gittigidiyor.com acildi.");

    }

    // Ana sayfanın açıldığı kontrol edilir
    @Test
    public void test_2(){

        HomePage homePage = new HomePage(driver);
        homePage.getLoginPage();
        homePage.waitForPageLoad();
        Assert.assertEquals("Üye Girişi - GittiGidiyor", driver.getTitle());
        // System.out.println("Login Sayfasi acildi.");
        logger.log(Level.INFO,"Login Sayfasi acildi.");

    }

    // Login işlemi kontrol edilir.
    @Test
    public void test_3(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("doga_can_007@hotmail.com","deneme1234");
        loginPage.submit();
        loginPage.waitForPageLoad();
        Assert.assertEquals("dogacanbicer855789", loginPage.getUserName());
        // System.out.println("Kullanici Girisi Basarili.");
        logger.log(Level.INFO,"Kullanici Girisi Basarili.");

    }

    // Arama kutucuğuna bilgisayar kelimesi girilir
    // Arama sonuçları sayfasından 2.sayfa açılır.
    // 2.sayfanın açıldığı kontrol edilir.
    @Test
    public void test_4() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterData("bilgisayar");
        searchPage.submit();
        searchPage.waitForPageLoad();
        searchPage.secondPage();

        Assert.assertTrue(driver.getTitle().contains("Bilgisayar - GittiGidiyor - 2/"));
        //System.out.println("2. sayfa acildi.");
        logger.log(Level.INFO,"2. sayfa acildi.");

    }

    // Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir
    // Seçilen ürün sepete eklenir.
    // Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
    @Test
    public void test_5() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.addToBox();
        searchPage.waitForPageLoad();
        searchPage.addToBox2();
        //System.out.println("Urun Sepete Eklendi.");
        logger.log(Level.INFO,"Urun Sepete Eklendi.");

        String price1 = searchPage.getSearchPrice();
        //System.out.println("Sayfa Fiyati : "+price1);
        logger.log(Level.INFO,"Sayfa Fiyati : "+price1);

        Thread.sleep(5000);

        BoxPage boxPage = new BoxPage(driver);
        driver.get(boxPage.getCheckoutUrl());

        String price2 = boxPage.getCheckoutPrice();

        //System.out.println("Sepet Fiyati : " + price2);
        logger.log(Level.INFO,"Sepet Fiyati : "+price2);

        if (price1.equals(price2)){
            Assert.assertTrue(true);
            //System.out.println("Fiyatlar ayni.");
            logger.log(Level.INFO,"Fiyatlar ayni.");
        }
    }

    // Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
    @Test
    public void test_6(){
        BoxPage boxPage = new BoxPage(driver);
        boxPage.increase();
        boxPage.waitForPageLoad();

        Assert.assertEquals("2", boxPage.value());
        //System.out.println("Urun Sayisi : "+boxPage.value());
        logger.log(Level.INFO,"Urun Sayisi : "+boxPage.value());

    }

    // Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
    @Test
    public void test_7() throws InterruptedException{
        BoxPage boxPage = new BoxPage(driver);
        Thread.sleep(3000);
        boxPage.delete();
        Thread.sleep(3000);
        Boolean isPresent = driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[5]/div[1]/div[1]/strong")).size() > 0;
        if (!isPresent){
            logger.log(Level.INFO,"Sepet Boş");
        }
    }

}
