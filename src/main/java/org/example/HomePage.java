package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends Utils{
    private By _registerButton = By.className("ico-register");
    private By _errorMessage = By.xpath("//div[@class='poll-vote-error']");
    private By _clickOnGood = By.xpath("//label[@for='pollanswers-2']");
    private By _clickOnVote = By.xpath("//button[@id='vote-poll-1']");
    public void clickOnRegisterButton(){
        clickOnElement(_registerButton);
    }
    public void communityPoll() {
        //click on good
        clickOnElement(_clickOnGood);
        //click on vote
        clickOnElement(_clickOnVote);
    }
    public void communityPollErrorMessage() {
        String expectedResult = "Only registered users can vote.";
        //add wait time till print the message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(_errorMessage));
        //get and print the message
        String actualResul = getTextFromElement(_errorMessage);
        System.out.println(actualResul);
        //check if actual result is same as expected
        Assert.assertEquals(actualResul, expectedResult, "Test Fail");
    }
}
