package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.example.Base_Page.driver;

public class Driver_Manager extends Utils {
    String browser = System.getProperty("browser");
    MutableCapabilities sauceOptions = new MutableCapabilities();
    public String USERNAME = "oauth-hchovatiya-1d021";
    public String ACCESS_KEY = "6e3fc752-32fb-4f76-977b-319bfe07ca28";
    public String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";
    public boolean SAUCE_LAB = false;
    public void openBrowser(){
        if (SAUCE_LAB){
            System.out.println("Executing in Sauce Lab with Browser........."+browser);
            if (browser.equalsIgnoreCase("Chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "112");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
            } else  if (browser.equalsIgnoreCase("edge")) {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "112");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }

            }else  if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "112");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println("executing in Browser.......");
        }
        if(browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver=new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver=new FirefoxDriver();
        }else {
            System.out.println("wrong Browser Name");
        }
        //open the url
        driver.get("https:/demo.nopcommerce.com/");
        //maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void closeBrowser() {
        //close the browser
        driver.close();
    }
}
