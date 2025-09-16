package MobileTesting;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestUtils.BaseTest;
import mobile.PageObjects.android.HomePage;

public class Home_Validatation extends BaseTest{
	
	@Test(dataProvider = "getData")
	public void verifyHomePageContentAfterLogin(HashMap<String,String> input) throws InterruptedException{
		
		HomePage homePage = new HomePage(driver);
		loginPage.startApp(input.get("Email"), input.get("Password"));
		 
	String Greet= homePage.getUserGreeting();
	Assert.assertEquals(Greet, "Hi,", "Greeting text not matched!");
	System.out.println(Greet);
		
	String UserName = homePage.getUserName();
	Assert.assertTrue(UserName.length() > 0, "Username not visible!");
    System.out.println(UserName);
		
	homePage.jobCardActivity();
	
	WebElement placements=homePage.internActivity();
	Assert.assertTrue(placements.isDisplayed(), "Placements section not found!");
	
	String  BlogsText= homePage.blogActivity();
	Assert.assertEquals(BlogsText, "Blogs", "Blogs text mismatch!");
	
	}

}
