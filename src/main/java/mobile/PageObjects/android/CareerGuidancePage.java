package mobile.PageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.ReusableActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CareerGuidancePage {

	ReusableActions actions;
	AndroidDriver driver;

	public CareerGuidancePage(AndroidDriver driver) {
		
		this.driver=driver;
		this.actions = new ReusableActions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

    @AndroidFindBy(accessibility="Career Guidance\nTab 4 of 5")
	 private WebElement careerGuidanceTab;
	
    
    @AndroidFindBy(accessibility="Today’s Event")
	 private WebElement TodayEventText;
    
    
    @AndroidFindBy(accessibility="Register Now")
  	 private WebElement registerNowTab;
	
    @AndroidFindBy(accessibility="Upcoming Events")
 	 private WebElement upcomingEventText;

    @AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.HorizontalScrollView[1]/android.widget.ImageView[3]")
  	 private WebElement bigDataImg;

    
    @AndroidFindBy(accessibility="Completed Webinars")
	 private WebElement comletedWebinarsText;
    
    
    @AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.HorizontalScrollView[2]/android.widget.ImageView[1]")
 	 private WebElement uiUxDesignImg;
    
    
    public boolean getIntoCareerGuidanceSection() {
  
    	    careerGuidanceTab.click();
         	return careerGuidanceTab.isEnabled();
    	   }
    
    
    public String goToTodayEvent() {
   
    	    return TodayEventText.getAttribute("content-desc");
    	   }
    
    public void goToRegisterNow() {
    	    actions.scrollToEndAction();
    	    actions.waitForVisibility(registerNowTab);
    	    registerNowTab.click();
    	      }
    
    public String goToUpcomingEvents() {
    	actions.scrollToEndAction();
    	actions.waitForVisibility(upcomingEventText);
    	    return upcomingEventText.getAttribute("content-desc");
    	   }
    
    public  void swipeBigDataImage() {
    	    actions.swipeAction(bigDataImg, "Left");
            }
    
    public  String goToCompleteWebinar() {
    	
            return comletedWebinarsText.getAttribute("content-desc");
           }
    
    public void swipeUiUxDesignImage() {
    	  actions.swipeAction(uiUxDesignImg, "Left");
    	  actions.navigateBack();
    	 }
    
    
    
    
    
    
}
