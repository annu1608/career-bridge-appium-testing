package MobileTesting;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestUtils.BaseTest;
import mobile.PageObjects.android.ProfilePage;

public class Profile_Validation extends BaseTest{
	
	
	@Test(dataProvider = "getData")
	public void ProfileFunctionality(HashMap<String,String> input) throws InterruptedException
	{
		ProfilePage profilePage = new ProfilePage(driver);
		loginPage.startApp(input.get("Email"), input.get("Password"));
		
		profilePage.goToProfile();
	    String profileName= profilePage.getAccountName();
	    System.out.println("Profile Name: "+profileName);
		
	    Assert.assertNotNull(profileName, "Profile name is missing!");
	    Assert.assertTrue(profileName.length() > 0, "Profile name is empty!");
	    
	    boolean logoutButtonStatus = profilePage.logOutAction();
	    Assert.assertTrue(logoutButtonStatus, "Logout button was not enabled after click!");
		
	}
	

}
