package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrackUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US5_View_Columns_On_Vehicle_Models_Page extends TestBase {

    @Test
    public void verify_managers_see_10_columns_in_the_web_table() {
        //Login as store and sales managers
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("storeManager1"), ConfigurationReader.getProperty("password"));

        //Click the Vehicle Model under the Fleet
        WebElement fleet = driver.findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        BrowserUtils.sleep(3);
        fleet.click();
        WebElement vehicleModel = driver.findElement(By.xpath("//div[@id = 'main-menu']//span[text()='Vehicles Model']"));
        vehicleModel.click();

        //Verify managers see 10 columns in the web-table
        //Expected Column names:
        //   MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED), TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS
        List<String> expectedColumnNames = new ArrayList<>(Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED", "CVVI", "CO2 FEE (/MONTH)", "COST (DEPRECIATED)", "TOTAL COST (DEPRECIATED)", "CO2 EMISSIONS", "FUEL TYPE", "VENDORS"));

        // verify "model name"
        WebElement column1 = driver.findElement(By.xpath("//table//th//span[.='Model Name']"));
        Assert.assertTrue(column1.isDisplayed());
        Assert.assertEquals(column1.getText(), expectedColumnNames.get(0));

        // verify the rest
        WebElement column2 = driver.findElement(By.xpath("//table//th//span[.='Make']"));
        Assert.assertTrue(column2.isDisplayed());
        Assert.assertEquals(column2.getText(), expectedColumnNames.get(1));

        WebElement column3 = driver.findElement(By.xpath("//table//th//span[.='Can be requested']"));
        Assert.assertTrue(column3.isDisplayed());
        Assert.assertEquals(column3.getText(), expectedColumnNames.get(2));

        WebElement column4 = driver.findElement(By.xpath("//table//th//span[.='CVVI']"));
        Assert.assertTrue(column4.isDisplayed());
        Assert.assertEquals(column4.getText(), expectedColumnNames.get(3));

        WebElement column5 = driver.findElement(By.xpath("//table//th//span[.='CO2 Fee (/month)']"));
        Assert.assertTrue(column5.isDisplayed());
        Assert.assertEquals(column5.getText(), expectedColumnNames.get(4));

        WebElement column6 = driver.findElement(By.xpath("//table//th//span[.='Cost (Depreciated)']"));
        Assert.assertTrue(column6.isDisplayed());
        Assert.assertEquals(column6.getText(), expectedColumnNames.get(5));

        WebElement column7 = driver.findElement(By.xpath("//table//th//span[.='Total Cost (Depreciated)']"));
        Assert.assertTrue(column7.isDisplayed());
        Assert.assertEquals(column7.getText(), expectedColumnNames.get(6));

        WebElement column8 = driver.findElement(By.xpath("//table//th//span[.='CO2 Emissions']"));
        Assert.assertTrue(column8.isDisplayed());
        Assert.assertEquals(column8.getText(), expectedColumnNames.get(7));

        WebElement column9 = driver.findElement(By.xpath("//table//th//span[.='Fuel Type']"));
        Assert.assertTrue(column9.isDisplayed());
        Assert.assertEquals(column9.getText(), expectedColumnNames.get(8));

        WebElement column10 = driver.findElement(By.xpath("//table//th//span[.='Vendors']"));
        Assert.assertTrue(column10.isDisplayed());
        Assert.assertEquals(column10.getText(), expectedColumnNames.get(9));

    }

    @Test
    public void verify_drivers_see_the_error_message() {

        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("driver3"), ConfigurationReader.getProperty("password"));





    }
}
