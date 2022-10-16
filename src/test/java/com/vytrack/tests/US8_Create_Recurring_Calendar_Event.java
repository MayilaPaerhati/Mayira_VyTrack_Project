package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrackUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US8_Create_Recurring_Calendar_Event extends TestBase {

    @Test
    public void verify_the_repeat_number_is_1(){
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

        //Verify the repeat number is 1
        WebElement inputRepeatNum = driver.findElement(By.xpath("(//label[@class='fields-row'])[1]//input[@type='text']"));
        String actualValue = inputRepeatNum.getAttribute("value");
        Assert.assertEquals(actualValue, "1");

    }

    @Test
    public void verify_the_app_displays_message(){
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

        //Clear(delete) the number 1
        //Verify the app displays “This value should not be blank.”
        WebElement inputRepeatNum = driver.findElement(By.xpath("(//label[@class='fields-row'])[1]//input[@type='text']"));
        inputRepeatNum.clear();

        WebElement message = driver.findElement(By.xpath("//span[starts-with(@id, 'temp-validation')]"));
        Assert.assertTrue(message.getText().contains("This value should not be blank."));

    }
}
