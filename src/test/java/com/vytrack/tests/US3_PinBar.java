package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrackUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.module.Configuration;

public class US3_PinBar extends TestBase {

    @Test
    public void users_click_pinBar_verify_two_messages() {
        //Users are on the homepage
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("salesManager2"), ConfigurationReader.getProperty("password"));

        //Click the Learn how to use this space message
        WebElement learnMsg = driver.findElement(By.xpath("//div[@class='pin-bar-empty']/a"));
        BrowserUtils.sleep(5);
        learnMsg.click();

        //Verify the users see 2 messages:
        //“How To Use Pinbar”
        BrowserUtils.sleep(5);
        WebElement message1 = driver.findElement(By.xpath("//div[@id='container']//h3"));
        Assert.assertEquals(message1.getText(), "How To Use Pinbar");

        //“Use pin icon on the right top corner of the page to create fast access link in the pinbar.”
        WebElement message2 = driver.findElement(By.xpath("//div[@id='container']//p[1]"));
        Assert.assertEquals(message2.getText(), "Use pin icon on the right top corner of page to create fast access link in the pinbar.");

    }

    @Test
    public void users_click_pinBar_verify_image_source(){
        //Users are on the homepage
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("driver2"), ConfigurationReader.getProperty("password"));

        //Click the Learn how to use this space message
        WebElement learnMsg = driver.findElement(By.xpath("//div[@class='pin-bar-empty']/a"));
        BrowserUtils.sleep(5);
        learnMsg.click();

        //Verify users see an image
        WebElement image = driver.findElement(By.xpath("//div[@id='container']//p[2]/img"));

        //Automation testing - verify image source : /bundles/oronavigation/images/pinbar-location.jpg
        String actualSrc = image.getAttribute("src");
        String expectedSrc = "/bundles/oronavigation/images/pinbar-location.jpg";

        BrowserUtils.sleep(5);
        Assert.assertTrue(actualSrc.contains(expectedSrc));


    }
}
