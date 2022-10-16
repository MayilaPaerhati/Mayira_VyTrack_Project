package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrackUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US6_Edit_Car_Info_Icons extends TestBase{

    @Test
    public void driver_verify_edit_car_info_icons(){

        // Users are on the homepage
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("driver4"), ConfigurationReader.getProperty("password"));

        // Click the Vehicles under the Fleet
        WebElement fleet = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        fleet.click();
        WebElement vehicles = driver.findElement(By.xpath("//div[@id='main-menu']//span[.='Vehicles']"));
        vehicles.click();

        // Verify any car info has 3 dots “...”, and there are “view, edit, delete” icons.
        WebElement dots = driver.findElement(By.xpath("(//div[@class='dropdown'])[1]/a"));
        BrowserUtils.sleep(3);
        dots.click();

        WebElement icon1 = driver.findElement(By.xpath("(//div[@class='dropdown'])[1]//li[@class='launcher-item'][1]/a"));
        WebElement icon2 = driver.findElement(By.xpath("(//div[@class='dropdown'])[1]//li[@class='launcher-item'][2]/a"));
        WebElement icon3 = driver.findElement(By.xpath("(//div[@class='dropdown'])[1]//li[@class='launcher-item'][3]/a"));

        Assert.assertEquals(icon1.getAttribute("title").toLowerCase(), "view");
        Assert.assertEquals(icon2.getAttribute("title").toLowerCase(), "edit");
        Assert.assertEquals(icon3.getAttribute("title").toLowerCase(), "delete");

    }


    @Test
    public void managers_verify_edit_car_info_icons(){

        // Users are on the homepage
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("storeManager2"), ConfigurationReader.getProperty("password"));

        // Click the Vehicles under the Fleet
        WebElement fleet = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        fleet.click();
        WebElement vehicles = driver.findElement(By.xpath("//div[@id='main-menu']//span[.='Vehicles']"));
        vehicles.click();

        // Verify any car info has 3 dots “...”, and there are “view, edit, delete” icons.
        WebElement dots = driver.findElement(By.xpath("(//div[@class='dropdown'])[1]/a"));
        BrowserUtils.sleep(3);
        dots.click();

        WebElement icon1 = driver.findElement(By.xpath("(//div[@class='dropdown'])[1]//li[@class='launcher-item'][1]/a"));
        WebElement icon2 = driver.findElement(By.xpath("(//div[@class='dropdown'])[1]//li[@class='launcher-item'][2]/a"));
        WebElement icon3 = driver.findElement(By.xpath("(//div[@class='dropdown'])[1]//li[@class='launcher-item'][3]/a"));

        Assert.assertEquals(icon1.getAttribute("title").toLowerCase(), "view");
        Assert.assertEquals(icon2.getAttribute("title").toLowerCase(), "edit");
        Assert.assertEquals(icon3.getAttribute("title").toLowerCase(), "delete");
    }



}
