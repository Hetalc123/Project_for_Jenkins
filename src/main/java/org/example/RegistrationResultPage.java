package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils{
    private By _printMessage = By.xpath("//div[@class='result']");

    public void verifyUserRegisteredSuccesfullyOrNot(){
        String expectedResult = "Your registration completed";
        //get text and print
        String actualResult = getTextFromElement(_printMessage);
        System.out.println("Message on screen is =>" + (actualResult));
        //check if actual result is same as expected
        Assert.assertEquals(actualResult, expectedResult, "Registration not completed");
    }
}
