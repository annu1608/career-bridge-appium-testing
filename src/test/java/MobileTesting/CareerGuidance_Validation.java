package MobileTesting;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestUtils.BaseTest;
import mobile.PageObjects.android.CareerGuidancePage;

public class CareerGuidance_Validation extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void checkCareerGuidanceMenuPresence(HashMap<String,String> input) throws InterruptedException {
		
		CareerGuidancePage careerGuidancePage = new CareerGuidancePage(driver);
		
		loginPage.startApp(input.get("Email"), input.get("Password"));
		
		boolean careerGuidanceClick = careerGuidancePage.getIntoCareerGuidanceSection();
		Assert.assertTrue(careerGuidanceClick, "Career Guidance Tab click failed!");
		
		String todayEventLabel=careerGuidancePage.goToTodayEvent();
	    Assert.assertEquals(todayEventLabel, "Today’s Event");
		
		careerGuidancePage.goToRegisterNow();
		
	    String upComingLabel=careerGuidancePage.goToUpcomingEvents();
	    Assert.assertEquals(upComingLabel, "Upcoming Events");
		
		careerGuidancePage.swipeBigDataImage();
	
	    String completeWebinarLabel= careerGuidancePage.goToCompleteWebinar();
        Assert.assertEquals(completeWebinarLabel, "Completed Webinars");
	  		
	    careerGuidancePage.swipeUiUxDesignImage();
	    		
	    		
	    		
	
	
	}

}
