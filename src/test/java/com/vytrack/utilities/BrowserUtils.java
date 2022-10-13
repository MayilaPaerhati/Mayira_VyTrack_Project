package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BrowserUtils {

    public static void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception happened in sleep method!");
        }
    }


    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        String actualTile = driver.getTitle();
        Assert.assertEquals(actualTile, expectedTitle);
    }


    public static void login(WebDriver driver, String username){
        driver.get("https://qa2.vytrack.com/user/login");

        WebElement inputUsername = driver.findElement(By.id("prependedInput"));
        inputUsername.sendKeys(username);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.sendKeys("UserUser123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[.='Log in']"));
        loginBtn.click();

    }

}
