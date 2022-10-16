package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrackUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class US2_Access_To_Oroinc_Documentation_Page extends TestBase{

    @Test
    public void access_to_oroinc_documentation_page(){
        //Users are on the homepage
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrackUtilities.login(driver, ConfigurationReader.getProperty("driver2"), ConfigurationReader.getProperty("password"));

        //Click the question icon on the right top of the homepage
        WebElement questionIcon = driver.findElement(By.xpath("//i[@title='Get help']"));
        questionIcon.click();

        //Verify the users access to the Oronic Documentation page

        Set<String> allWindows = driver.getWindowHandles();

        for (String eachWindow: allWindows){
            driver.switchTo().window(eachWindow);
            if (eachWindow.contains("Oro Documentation")){
                break;
            }
        }

        String expectedHeader = "Welcome to Oro Documentation";
        String actualHeader = driver.findElement(By.tagName("h1")).getText();

        BrowserUtils.sleep(3);
        Assert.assertEquals(actualHeader, expectedHeader);
    }

}
