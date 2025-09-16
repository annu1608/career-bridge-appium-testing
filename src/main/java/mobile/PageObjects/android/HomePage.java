package mobile.PageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Utils.ReusableActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

    ReusableActions actions;
	AndroidDriver driver;
	
	
	public HomePage(AndroidDriver driver) {
		
		this.driver= driver;
	    this.actions = new ReusableActions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Hi,']")
	private WebElement hiElement;
	
	@AndroidFindBy(xpath="//android.view.View[@index='1']")
	private WebElement userName;
	
	@AndroidFindBy(accessibility="Backend Engineer\nWmware\nCA\nFresher\nFull-Time")
	private WebElement backendEngineerTab;
	
	@AndroidFindBy(accessibility="Company\nTab 2 of 3")
	private WebElement compnyTab;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Reviews\nTab 3 of 3']")
	private WebElement reviewsTab;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.HorizontalScrollView[3]")
	private WebElement internshipTab;
	
	@AndroidFindBy(accessibility="Blogs")
	private WebElement BlogsText;
	
	@AndroidFindBy(accessibility="See more")
	private WebElement seeMoreTab;
	

	
     public String getUserGreeting(){
    	      String greeting = hiElement.getAttribute("content-desc");
			     return greeting;
			}
     
     public String getUserName() {
		    String name = userName.getAttribute("content-desc");
            return name;
		}
			
    public void jobCardActivity() {
    	 
    	backendEngineerTab.click();
 	    compnyTab.click();
 	    reviewsTab.click();
 	    actions.scrollToEndAction();
 	    actions.navigateBack();
 	    actions.swipeAction( backendEngineerTab , "left");
 	    
     }
     
   
    
    public WebElement internActivity() {
    	
    	actions.swipeAction( internshipTab , "left");
		return actions.scrollToElementByDesc("Placements") ;
	        
    	}
    
    public String blogActivity() {
    	
                    String blogText  =	BlogsText.getAttribute("content-desc");
                    seeMoreTab.click();
             		actions.scrollToElementByDesc("VISIT BLOG NOW") ;
	            	actions.navigateBack() ;
                    
                   return blogText;
                   }
		
	            	
		 
	        
    	
    
	 }
	 

