package com.cybertek.test;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CherCherTest {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();


    }
    @Test
    public void alertpresenttest1(){
        WebElement initiateALert = driver.findElement(By.id("alert"));
        initiateALert.click();
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        // handle javascript alert
        // if you don't wait you will get NoAlertPresentException: no such alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void DisabledButtonTest(){
        WebElement button = driver.findElement(By.id("disable"));
        System.out.println("button.isEnabled() = " + button.isEnabled()); //false

        WebElement buttoninnitiator = driver.findElement(By.id("enable-button"));
        buttoninnitiator.click();

        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(button));

        System.out.println("button.isEnabled() = " + button.isEnabled());
        Assert.assertTrue(button.isEnabled(),"verify that button is enable");

        button.click();




    }

}
