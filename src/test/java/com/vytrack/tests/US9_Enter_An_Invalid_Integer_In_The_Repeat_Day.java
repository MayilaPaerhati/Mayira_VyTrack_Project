package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrackUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US9_Enter_An_Invalid_Integer_In_The_Repeat_Day extends TestBase {

    @Test
    public void verify_the_app_displays_message() {
        //Users are on the homepage
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("driver5"), ConfigurationReader.getProperty("password"));

        //Click the “Calendar Events” under the Activities
        WebElement activities = driver.findElement(By.xpath("(//div[@id='main-menu']//span[contains(text(), 'Activities')])[1]"));
        activities.click();

        WebElement calendarEvents = driver.findElement(By.linkText("Calendar Events"));
        BrowserUtils.sleep(2);
        calendarEvents.click();

        //Click the “Create Calendar Event” button
        WebElement createCalendarEventBtn = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        BrowserUtils.sleep(3);
        createCalendarEventBtn.click();

        //Check the Repeat checkbox
        WebElement repeatCheckbox = driver.findElement(By.xpath("//input[starts-with(@id, 'recurrence-repeat')]"));
        BrowserUtils.sleep(3);
        repeatCheckbox.click();

        //Users enter an INVALID integer (x<1 || x>99)
        //Verify users get 2 error messages
        WebElement inputRepeatNum = driver.findElement(By.xpath("(//label[@class='fields-row'])[1]//input[@type='text']"));

        // enter number < 1:
        inputRepeatNum.clear();
        inputRepeatNum.sendKeys("-2");

        WebElement message1 = driver.findElement(By.xpath("//span[starts-with(@id, 'temp-validation')]"));
        Assert.assertTrue(message1.getText().contains("The value have not to be less than 1."));

        // enter number > 99
        inputRepeatNum.clear();
        inputRepeatNum.sendKeys("100");

        WebElement message2 = driver.findElement(By.xpath("//span[starts-with(@id, 'temp-validation')]"));
        Assert.assertTrue(message2.getText().contains("The value have not to be more than 99."));

    }
}
