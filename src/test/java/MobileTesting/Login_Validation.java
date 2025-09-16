package MobileTesting;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import TestUtils.BaseTest;

public class Login_Validation extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void verifySuccessfulLoginToast(HashMap<String,String> input)throws InterruptedException {
		
		String expectedToastMessage ="Login Successful";
		  
		   loginPage.startApp(input.get("Email"), input.get("Password"));
		   String	actuallToastMessage =loginPage.getToastMessage();
     	System.out.println("Toast Message: " + actuallToastMessage);
	
	Assert.assertEquals(actuallToastMessage, expectedToastMessage);
	
	
	}
	
	@Test
	public void verifyInvalidPasswordToast() {
		
		
		   loginPage.nextSetup() ;
		   loginPage.setEmail("annu.crpf@gmail.com");
		   loginPage.setPassword("Annu@1232111");
		   loginPage.clickLoginButton();
		
  	String	ToastMessage =loginPage.getToastMessage();
 
	 Assert.assertTrue(ToastMessage.contains("Your password is wrong."),
             "Expected toast not shown!"); 
 	
	
		
	}
	
	@Test
	public void verifyInvalidEmailToast() {
		
		
		   loginPage.nextSetup() ;
		   loginPage.setEmail("abcd@abcd");
		   loginPage.setPassword("Annu@123");
		   loginPage.clickLoginButton();
		
  	String	ToastMessage =loginPage.getToastMessage();
  	System.out.println("Displayed Toast: "+ ToastMessage);
	
    Assert.assertTrue(ToastMessage.contains("User with this email doesn't exist."),
            "Expected toast not shown!"); 
	
		
	}
	
	
}
