package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrackUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US10_Write_Description_When_Create_Calendar_Event extends TestBase {

    @Test
    public void users_write_description() {
        // Login: Users are on the homepage
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("salesManager3"), ConfigurationReader.getProperty("password"));

        //Click the “Calendar Events” under the Activities
        WebElement activities = driver.findElement(By.xpath("(//div[@id='main-menu']//span[contains(text(), 'Activities')])[1]"));
        activities.click();

        WebElement calendarEvents = driver.findElement(By.linkText("Calendar Events"));
        BrowserUtils.sleep(2);
        calendarEvents.click();

        // Click the “Create Calendar Event” button
        WebElement createCalendarEventBtn = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        BrowserUtils.sleep(3);
        createCalendarEventBtn.click();

        // Write a message in the Description field
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'oro')]")));

        WebElement descriptionInput = driver.findElement(By.id("tinymce"));
        descriptionInput.sendKeys("Last day of java class");

        // Verify the message is written in the input box
        WebElement message = driver.findElement(By.xpath("//body[@id = 'tinymce']/p"));
        String actualMessage = message.getText();
        BrowserUtils.sleep(2);
        String expectedMessage = "Last day of java class";

        Assert.assertTrue(message.isDisplayed(), "There is no message in input field");
        BrowserUtils.sleep(2);
        Assert.assertEquals(actualMessage, expectedMessage, "Message verification is Failed.");

        driver.switchTo().defaultContent();

    }


}



