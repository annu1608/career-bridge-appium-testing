package MobileTesting;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestUtils.BaseTest;
import mobile.PageObjects.android.SignUpPage;

public class SignUp_Validation extends BaseTest{
	
	@Test(dataProvider="getSignUpData")
	public void signUpFormFieldChecking(HashMap<String,String> input) {
		
	SignUpPage signUpPage = new SignUpPage(driver);	
	     loginPage.getStart();
	    String signUp= signUpPage.getIntoSignUpSection();
	   Assert.assertEquals(signUp, "Sign Up", "Sign Up section not opened properly!");
	    
	    signUpPage.enterUserName(input.get("AccountHolderName"));
	    signUpPage.enterUserEmail(input.get("Email"));
	    signUpPage.enterUserPassword(input.get("Password"));
	    signUpPage.enterUserConfirmedPassword(input.get("ConfirmPassword"));
	   
	   String termsAndConditon=signUpPage.tickCheckBox();
		 
	    Assert.assertEquals(termsAndConditon, "Agree Terms and Conditions", "Terms checkbox not ticked properly!");
	    
	    signUpPage.clickSignUpTab();
	    String  ToastMessage= signUpPage.getToastMessage();
	    System.out.println("Toast Message: "+ToastMessage);
	    
	    signUpPage.clickLoginTab();
	}
	
	@Test
	public void signUpWithInvalidEmail() {
		
		
		SignUpPage signUpPage = new SignUpPage(driver);	
	    loginPage.getStart();
	    signUpPage.getIntoSignUpSection();
	    
	    signUpPage.enterUserName("pooja kumari");
	    signUpPage.enterUserEmail("abcdef@abcd");
	    signUpPage.enterUserPassword("123456");
	    signUpPage.enterUserConfirmedPassword("123456");
	    signUpPage.tickCheckBox();
		signUpPage.clickSignUpTab();
	    
	    String  ToastMessage= signUpPage.getToastMessage();
	   
	   Assert.assertTrue(ToastMessage.contains("The email address is badly formatted."),
	               "Expected toast not shown!"); 
	
		
	}
	
	@Test
    public void passwordLenghthMustBe() {
	
		SignUpPage signUpPage = new SignUpPage(driver);	
	    loginPage.getStart();
	    signUpPage.getIntoSignUpSection();
	    
	    signUpPage.enterUserName("pooja kumari");
        signUpPage.enterUserEmail("poojakumari16@gmail.com");
        signUpPage.enterUserPassword("1234");
        String passwordLength= signUpPage.lenghtOfPswdMustBe();
       
        Assert.assertTrue(passwordLength.contains("Enter Valid Password(Min. 6 Character)"),
	               "Expected toast not shown!"); 
	
}
}
