package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrackUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US1_Accessing_All_Main_Modules extends TestBase{

    @Test
    public void store_and_sales_managers_accessing_all_main_modules(){

        // 1. login as a salesmanager or storemanagers
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("salesManager1"), ConfigurationReader.getProperty("password"));

        // 2. Verify the users see 8 modules: Dashboards, Fleet, Customers, Sales, Activities, Marketing, Reports & Segments, System
        WebElement dashboards = driver.findElement(By.xpath("//div[@id='breadcrumb']//li[1]"));
        BrowserUtils.sleep(3);
        Assert.assertTrue(dashboards.isDisplayed());
        BrowserUtils.sleep(3);
        Assert.assertTrue(dashboards.getText().contains("Dashboards"));

        WebElement fleet = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        Assert.assertTrue(fleet.isDisplayed());
        Assert.assertEquals(fleet.getText(), "Fleet");

        WebElement customers = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][2]"));
        Assert.assertTrue(customers.isDisplayed());
        Assert.assertEquals(customers.getText(), "Customers");

        WebElement sales = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][3]"));
        Assert.assertTrue(sales.isDisplayed());
        Assert.assertEquals(sales.getText(), "Sales");

        WebElement activities = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][4]"));
        Assert.assertTrue(activities.isDisplayed());
        Assert.assertEquals(activities.getText(), "Activities");

        WebElement marketing = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][5]"));
        Assert.assertTrue(marketing.isDisplayed());
        Assert.assertEquals(marketing.getText(), "Marketing");

        WebElement reportsAndSegments = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][6]"));
        Assert.assertTrue(reportsAndSegments.isDisplayed());
        Assert.assertEquals(reportsAndSegments.getText(), "Reports & Segments");

        WebElement system = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][6]/following-sibling::li"));
        Assert.assertTrue(system.isDisplayed());
        Assert.assertEquals(system.getText(), "System");

    }

    @Test
    public void drivers_accessing_all_main_modules(){

        //1. login as a driver
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("driver1"),ConfigurationReader.getProperty("password"));

        //2. Verify the users see 4 modules: Fleet, Customers, Activities, System
        WebElement fleet = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        Assert.assertTrue(fleet.isDisplayed());
        Assert.assertEquals(fleet.getText(), "Fleet");

        WebElement customers = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][2]"));
        Assert.assertTrue(customers.isDisplayed());
        Assert.assertEquals(customers.getText(), "Customers");

        WebElement activities = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][3]"));
        Assert.assertTrue(activities.isDisplayed());
        Assert.assertEquals(activities.getText(), "Activities");

        WebElement system = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][3]/following-sibling::li"));
        Assert.assertTrue(system.isDisplayed());
        Assert.assertEquals(system.getText(), "System");

    }
}
