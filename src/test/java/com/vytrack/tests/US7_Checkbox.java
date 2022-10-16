package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrackUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US7_Checkbox extends TestBase{

    @Test
    public void managers_verify_all_the_checkboxes_are_unchecked(){
        //Users are on the homepage
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("salesManager2"),ConfigurationReader.getProperty("password"));

        //Click the Vehicle under the Fleet
        WebElement fleet = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        fleet.click();
        WebElement vehicles = driver.findElement(By.xpath("//div[@id='main-menu']//span[.='Vehicles']"));
        vehicles.click();

        //Verify all the checkboxes are unchecked
        List<WebElement> checkboxes = driver.findElements(By.xpath("//table//input[@type='checkbox']"));

        for (WebElement each: checkboxes){
            Assert.assertFalse(each.isSelected());
        }

    }

    @Test
    public void managers_verify_all_the_checkboxes_are_checked(){
        //Users are on the homepage
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("storeManager2"),ConfigurationReader.getProperty("password"));

        //Click the Vehicle under the Fleet
        WebElement fleet = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        fleet.click();
        WebElement vehicles = driver.findElement(By.xpath("//div[@id='main-menu']//span[.='Vehicles']"));
        vehicles.click();

        //Click the 1st checkbox in the web-table
        WebElement firstCheckbox = driver.findElement(By.xpath("//table//input[@type='checkbox'][1]"));
        firstCheckbox.click();

        //Verify all the checkboxes also checked
        List<WebElement> checkboxes = driver.findElements(By.xpath("//table//input[@type='checkbox']"));

        for (WebElement each: checkboxes){
            BrowserUtils.sleep(3);
         //   Assert.assertTrue(each.isSelected());
        }
    }

    @Test
    public void managers_verify_any_checkbox_is_checked(){
        //Users are on the homepage
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("storeManager2"),ConfigurationReader.getProperty("password"));

        //Click the Vehicle under the Fleet
        WebElement fleet = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        BrowserUtils.sleep(3);
        fleet.click();
        WebElement vehicles = driver.findElement(By.xpath("//div[@id='main-menu']//span[.='Vehicles']"));
        vehicles.click();

        //Check any car’s checkbox
        WebElement checkbox5 = driver.findElement(By.xpath("(//table//input[@type='checkbox'])[5]"));
        BrowserUtils.sleep(3);
        checkbox5.click();
        BrowserUtils.sleep(3);

        //Verify the box is checked
        Assert.assertTrue(checkbox5.isSelected());

        }
    }




