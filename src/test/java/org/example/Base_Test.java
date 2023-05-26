package org.example;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.DriverManager;

public class Base_Test extends Utils{
   Driver_Manager driverManager = new Driver_Manager();
    @BeforeMethod
    public void setUp(){
        driverManager.openBrowser();
    }
    @AfterMethod
    public void tearDown(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus()) {
            captureScreenshot("Screenshots");
        }
        driverManager.closeBrowser();
    }
}
