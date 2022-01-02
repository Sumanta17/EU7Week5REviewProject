package com.cybertek.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


    public class WebDriverFactory {

        //Task:
        //write a static method that takes a string parameter name: browserType
        //based on the value of parameter
        //it will setup the browser and
        //the method will return chromedriver or edgedriver object.
        //name of the method: getDriver

        public  static  WebDriver getDriver (String browserType){

            WebDriver driver = null;

            //Chrome,CHROME,ChrOme
            switch (browserType.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }

            return driver;
        }
    }

