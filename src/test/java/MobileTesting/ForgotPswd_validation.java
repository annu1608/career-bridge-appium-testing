package MobileTesting;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestUtils.BaseTest;
import mobile.PageObjects.android.ForgotPswdPage;

public class ForgotPswd_validation extends BaseTest {
	
	
	@Test(dataProvider = "getForgotPasswordLinkiData")
	public void forgotpswdChecking(HashMap<String,String> input) {
		
		ForgotPswdPage forgotPswdPage = new ForgotPswdPage(driver);
		loginPage.getStart();
		
		String resetLinkText= forgotPswdPage.setForgotPswd();
		
		  Assert.assertEquals(resetLinkText, "Enter your email for password reset link",
	                "Reset link text is not matching!");
		  
		  forgotPswdPage.getEmailField(input.get("Email"));
		  
		  
		  String	ToastMessage =loginPage.getToastMessage();;
	       System.out.println(ToastMessage);
	
		  Assert.assertTrue(ToastMessage.contains("Password Reset Mail Sent"),
	               "Expected toast not shown!");
	}
	
	
	@Test
	public void forgotpswdWithWorngEmail() {
		
		ForgotPswdPage forgotPswdPage = new ForgotPswdPage(driver);
		loginPage.getStart();
		forgotPswdPage.setForgotPswd();
		
		 forgotPswdPage.getEmailField("abcd@abcd");
		  
		  
		  String	ToastMessage =loginPage.getToastMessage();;
	       System.out.println(ToastMessage);
	
	       Assert.assertTrue(ToastMessage.contains("The email address is badly formatted."),
	               "Expected toast not shown!"); 
		
	}
	

}
