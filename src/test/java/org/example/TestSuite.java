package org.example;

import org.testng.annotations.Test;

public class TestSuite extends Base_Test{
HomePage homePage = new HomePage();
RegistrationFormPage registrationFormPage = new RegistrationFormPage();
RegistrationResultPage registrationResultPage = new RegistrationResultPage();
@Test
    public void toVerifyUserShouldAbleToRegisterSuccessfully(){
homePage.clickOnRegisterButton();
registrationFormPage.enterRegistrationDetails();
registrationResultPage.verifyUserRegisteredSuccesfullyOrNot();
}
@Test
    public void toVerifyNonRegisteredUserShouldNotBeAbleToVote(){
    homePage.communityPoll();
    homePage.communityPollErrorMessage();
}
}
