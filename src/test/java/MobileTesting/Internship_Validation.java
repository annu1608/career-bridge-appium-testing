package MobileTesting;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestUtils.BaseTest;
import mobile.PageObjects.android.InternshipPage;

public class Internship_Validation extends BaseTest{
	
	@Test(dataProvider = "getData")
	public void summerInterChecking(HashMap<String,String> input) throws InterruptedException {
		
		
		 InternshipPage internshipPage = new InternshipPage(driver);
		 loginPage.startApp(input.get("Email"), input.get("Password"));
		
		 internshipPage.getIntershipSection();
		 String actuallHeading =internshipPage.lookIntoSummerIntern().replaceAll("\\s+", " ").trim();
		 
		     Assert.assertEquals(actuallHeading, "We are looking for a Summer Intern");
		
         
         WebElement requirementTab= internshipPage.knowInternDetalis();
            Assert.assertTrue(requirementTab.isDisplayed(), "Requirements tab is not visible!");
         
         boolean eligibilityTab=   internshipPage.checkEligibility();
            Assert.assertTrue(eligibilityTab, "Eligibility tab is not visible!");

     
         internshipPage.lastActions();
	}
	
	
	

}
