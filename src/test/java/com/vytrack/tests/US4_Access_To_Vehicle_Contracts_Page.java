package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrackUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US4_Access_To_Vehicle_Contracts_Page extends TestBase{

    @Test
    public void verify_managers_can_access_Vehicle_Contacts_page(){
        //Login as store or salesmanager
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("storeManager1"), ConfigurationReader.getProperty("password"));

        //Click the Vehicle contracts under the Fleet
        WebElement fleet = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        fleet.click();
        WebElement vehicleContracts = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]//a[.='Vehicle Contracts']"));
        vehicleContracts.click();

        //Verify managers can access the Vehicle contracts page
        BrowserUtils.sleep(3);
        Assert.assertTrue(driver.getTitle().contains("Vehicle Contract"));

    }

    @Test
    public void verify_drivers_see_an_error_message(){
        //Login as drivers
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("driver3"), ConfigurationReader.getProperty("password"));

        //Click the Vehicle contracts under the Fleet
        WebElement fleet = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        fleet.click();
        WebElement vehicleContracts = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]//a[.='Vehicle Contracts']"));
        BrowserUtils.sleep(3);
        vehicleContracts.click();

        BrowserUtils.sleep(3);

        //Verify users see an error message: “You do not have permission to perform this action.”
        WebElement errorMsg = driver.findElement(By.xpath("(//div[@class='message'])[2]"));
        Assert.assertEquals(errorMsg.getText(), "You do not have permission to perform this action.");

    }
}
