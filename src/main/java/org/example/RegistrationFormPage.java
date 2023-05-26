package org.example;

import org.openqa.selenium.By;

public class RegistrationFormPage extends Utils{
    private By _typeFirstName = By.id("FirstName");
    private By _typeLastName =By.id("LastName");
    private By _typeEmail = By.name("Email");
    private By _typePassword =By.name("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _clickOnRegister = By.id("register-button");
    private By _clickOnLogin = By.className("ico-login");
    private By _dayOfBirth = By.xpath("//select[@name='DateOfBirthDay']");
    private By _monthOfBirth = By.xpath("//select[@name='DateOfBirthMonth']");
    private By _yearOfBirth = By.xpath("//select[@name='DateOfBirthYear']");
    public void enterRegistrationDetails(){
        //click on female radio button
        clickOnElement(By.xpath(("(//input[@type='radio'])[2]")));
        //type the firstname
        typeText(_typeFirstName, "MyFirstTest");
        //type the lastname
        typeText(_typeLastName, "Automation");
        //select day of birth
        selectElementByIndex(_dayOfBirth,4);
        //select month of birth)
        selectElementByText(_monthOfBirth,"August");
        //select year of birth
        selectElementValue(_yearOfBirth,"1989");
        //type the email
        typeText(_typeEmail, "myfirstauto" + timestamp() + "@gmail.com");
        //type password
        typeText(_typePassword, "auto1234");
        //confirm password
        typeText(_confirmPassword, "auto1234");
        //click on register
        clickOnElement(_clickOnRegister);
    }
}
