package mobile.PageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.ReusableActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage {

     AndroidDriver driver;
	 ReusableActions actions;

	public ProfilePage(AndroidDriver driver) {
		this.driver= driver;
		this.actions= new ReusableActions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	          }
	
	@AndroidFindBy(accessibility="Profile\nTab 5 of 5")
	private WebElement profileTab;
	
	@AndroidFindBy(className="android.view.View")
	private List<WebElement> profileOtpions;
	
	@AndroidFindBy(accessibility = "Log Out")
	private WebElement logOutTab;
	
	
	
	public void goToProfile() {
		
		profileTab.click();
		}

	public String getAccountName() {
	  
		int index = 1;

	        WebElement element = profileOtpions.get(index);
             String text = element.getText();
	        if (text == null || text.trim().isEmpty()) {
	            text = element.getAttribute("content-desc"); }
	                   
               if (text != null && !text.trim().isEmpty() && !"null".equalsIgnoreCase(text.trim())) {
	        	
	        	 return text.trim();  }
	        return null;
	                 }
	
	public boolean logOutAction() {
		boolean LogOutClick=logOutTab.isEnabled();
		logOutTab.click();
		return LogOutClick;
	}
	
	
	
	
	
	
	
	
	
}
