package com.cybertek.test;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownTest {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(" http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @AfterMethod
    public void tearDown(){
   //     driver.close();


    }

    @Test
    public void test1 (){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement orderbutton = driver.findElement(By.linkText("Order"));
        orderbutton.click();

        String expectedselectedoption = "MyMoney";
        WebElement productdropdownelement = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        Select productDropDown = new Select(productdropdownelement);
        String actualselectedoptions = productDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualselectedoptions,expectedselectedoption,"First option selected aint expected");


        productDropDown.selectByVisibleText("FamilyAlbum");

        WebElement quantityBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityBox.sendKeys("2");

        WebElement calculatebutton = driver.findElement(By.cssSelector("input[type=submit]"));
        calculatebutton.click();

        int expectedprice = 160;

        WebElement totalprice = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));

        int actualprice = Integer.parseInt(totalprice.getAttribute("value"));
        Assert.assertEquals(actualprice,expectedprice,"Price is Not As expected");



    }





}
