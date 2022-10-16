package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // Creating a private constructor, so we are closing access to the object of this class from outside any classes.
    private Driver(){}

    /*
    Making our 'driver' instance private, so that it is not reachable from outside any class
    We make it static, because we want it to run before anything else
    also we will use it in static method
     */
    private static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver == null){  // if driver/browser was never opened

            String browserType = ConfigurationReader.getProperty("browser").toLowerCase();

            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }
        // Same driver instance will be returned every time we call Driver.getDriver() method
        return driver;
    }
}
